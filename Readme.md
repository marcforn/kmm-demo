# Kotlin MultiPlatform Demo

## Pending Tasks:

* Bluetooth Integration iOS
* Unit Testing
* Inject ApplicationContext
* REST Interceptors & retries
* Logging DEBUG vs RELEASE: Obfuscate relevant information
* Coverage Tools
* Publish Artifact
* Automation Testing




## Successful milestones:

* **Module Abstraction**. A common module has been created which the rest of modules inject. All the business logic has been splitted in several modules such as launches (All information regarding SpaceX launches). A shared module has been created as a bridge with all feature modules.
* **REST Request**: Using Ktor a GET request to a public API and retrieve data on both platforms was executed successfully.
* **Logging REST**: Using Ktor-logging to show logs on the console was executed successfully.
* **Logging messages**: Local implementation was required. Logs not disabled on iOS Release.
* **Coroutines Retries**: Custom implementation has been done to retry failing REST connections.
* **Exception Handler**: Custom implementation has been created to ensure only CustomException is sent to domain layer.
* **Dependency Injection**: Koin was used to solve DI issue. When SDK is initialized the graph is created and all modules are injected.
* **Library Versions**: All library versions have been centralized into Dependencies.kt file.
* **Firebase Crashlytics**: It has to be implemented on application level -> Does report crashes from KMM Module
* **Firebase Performance**: It has to be implemented on application level -> Does report performance reports such as API response time and app loading times.
* **Bluetooth Integration [Android]**: Scan Devices, Connect & Disconnect works. Third party was used (BlueFalcon). Open source project that get updates every months.





## Issues found:

### Logging messages [iOS Support]:
There no native logging mechanism. Actual/Expect implementation was required. Logs not disabled on iOS Release.

### CustomException on Domain Layer [Pending Framework Update]:
The only way to populate to domain layer Custom Exception was adding @ExperimentalStdlibApi to all classes propagating the Exception. Review in the future the compatibility.

### Context Injection [FAILED]:
Could not inject Application context as Typealias, does not work together with the current version of KOIN.

### Bluetooth Integration [iOS]:
Pending to test in Real iOS device




## Reference links:

* https://github.com/touchlab/KaMPKit
* https://github.com/touchlab/KaMPKit/blob/master/docs/GENERAL_ARCHITECTURE.md
* https://github.com/icerockdev/moko-template
* https://github.com/AAkira/Kotlin-Multiplatform-Libraries
* https://libs.kmp.icerock.dev/
* https://kotlinlang.org/lp/mobile/case-studies/fastwork/




## Third Parties:

* [Ktor](https://ktor.io/docs/http-client-multiplatform.html): Network Frameword
* [Koin](https://johnoreilly.dev/posts/kotlinmultiplatform-koin/): DI Frameword
* [BlueFalcon](https://github.com/Reedyuk/blue-falcon): Bluetooth client




