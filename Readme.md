# Kotlin MultiPlatform Demo



## Pending Tasks:
* REST Interceptors & retries
* Unit Testing
* Bluetooth Integration iOS
* Coverage Tools
* Publish Artifact
* Git Submodule approach
* Automation Testing




## Successful milestones:
* **Module Abstraction**. A common module has been created which the rest of modules inject. All the business logic has been splitted in several modules such as launches (All information regarding SpaceX launches). A shared module has been created as a bridge with all feature modules.
* **REST Request**: Using Ktor a GET request to a public API and retrieve data on both platforms was executed successfully.
* **Logging REST**: Using Ktor-logging to show logs on the console was executed successfully.
* **Logging messages**: Local implementation was required. Debug flag provided on SDK initialization that hides all sensitive data in Release mode.
* **Coroutines Retries**: Custom implementation has been done to retry failing REST connections.
* **Exception Handler**: Custom implementation has been created to ensure only CustomException is sent to domain layer.
* **Dependency Injection**: Koin was used to solve DI issue. When SDK is initialized the graph is created and all modules are injected.
* **Library Versions**: All library versions have been centralized into Dependencies.kt file.
* **Firebase Crashlytics**: It has to be implemented on application level -> Does report crashes from KMM Module
* **Firebase Performance**: It has to be implemented on application level -> Does report performance reports such as API response time and app loading times.
* **Bluetooth Integration [Android]**: Scan Devices, Connect & Disconnect works. Third party was used (BlueFalcon). Open source project that get updates every months.
* **Inject ApplicationContext**: Using typealias for PlatformContext we can initialize SDK with Application for Android and UIView for iOS with a single invocation.
* **Run app on Real Devices**: Both apps works as expected. The only caveat we should take is to delete xcode-frameworks folder from xcode when switching from emulator and real device in order to build .framework with proper architecture.
* **Proguard Enabled**: Code shrinking and obfuscation was successfully implemented on Android. Proguard files are provided by modules (consumerProguardFiles) and SDK client does not need to add any extra configuration on their side.





## Issues found:
### CustomException on Domain Layer [Pending Framework Update]:
The only way to populate to domain layer Custom Exception was adding @ExperimentalStdlibApi to all classes propagating the Exception. Review in the future the compatibility.

### Bluetooth Integration [iOS]:
Unexpected error from Bluefalcon when initializing SDK.

### Unit Testing:
Test can only be executed by gradle script, cannot be found in IDE (Gradle->Verification->Test)




## Reference links:
* https://github.com/touchlab/KaMPKit
* https://github.com/touchlab/KaMPKit/blob/master/docs/GENERAL_ARCHITECTURE.md
* https://github.com/icerockdev/moko-template
* https://github.com/AAkira/Kotlin-Multiplatform-Libraries
* https://libs.kmp.icerock.dev/
* https://kotlinlang.org/lp/mobile/case-studies/fastwork/
* https://gitlab.com/terrakok/gitlab-client/-/tree/develop




## Third Parties:
* [Ktor](https://ktor.io/docs/http-client-multiplatform.html): Network Framework
* [Koin](https://johnoreilly.dev/posts/kotlinmultiplatform-koin/): DI Framework
* [BlueFalcon](https://github.com/Reedyuk/blue-falcon): Bluetooth client




