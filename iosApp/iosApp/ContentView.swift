import SwiftUI
import shared

struct ContentView: View {
  @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        NavigationView {
            listView()
            .navigationBarTitle("SpaceX Launches")
            .navigationBarItems(trailing:
                Button("Reload") {
                    self.viewModel.loadLaunches()
            })
        }
    }

    private func listView() -> AnyView {
        switch viewModel.launches {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let launches):
            return AnyView(List(launches) { launch in
                RocketLaunchRow(rocketLaunch: launch)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {

    enum LoadableLaunches {
        case loading
        case result([LaunchesLaunch])
        case error(String)
    }
    
    enum LoadablePeripherals {
        case loading
        case result([BluetoothPeripheral])
        case error(String)
    }

    class ViewModel: ObservableObject {
        let sdk: SdkManager
        @Published var launches = LoadableLaunches.loading
        @Published var peripherals = LoadablePeripherals.loading

        init(sdk: SdkManager) {
            self.sdk = sdk
            self.loadLaunches()
        }

        func loadLaunches() {
            self.launches = .loading
            sdk.initialize(applicationContext: UIView())
            
            sdk.provideBluetooth().getPeripherals(completionHandler: {peripherals, error in
                if let peripherals = peripherals {
                    self.peripherals = .result(peripherals)
                    print(self.peripherals)
                } else {
                    self.peripherals = .error(error?.localizedDescription ?? "error")
                    print(error?.localizedDescription ?? "error")
                }
            })
            
            sdk.provideLaunches().getLaunches(completionHandler: { launches, error in
                if let launches = launches {
                    self.launches = .result(launches)
                } else {
                    self.launches = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}

extension LaunchesLaunch: Identifiable { }
