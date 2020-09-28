//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Ekaterina.Petrova on 25.08.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchRow: View {
    var rocketLaunch: LaunchesLaunch

    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(rocketLaunch.missionName)")
                Text(launchText).foregroundColor(launchColor)
                Text("Launch year: \(String(rocketLaunch.launchYear))")
                Text("Launch details: \(rocketLaunch.details)")
            }
            Spacer()
        }
    }
}

extension RocketLaunchRow {
   private var launchText: String {
    return rocketLaunch.launchSuccess ? "Successful" : "Unsuccessful"
    
   }

   private var launchColor: Color {
    return rocketLaunch.launchSuccess ? Color.green : Color.red
   }
}
