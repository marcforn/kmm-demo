# Kotlin MultiPlatform Demo

## Pending Tasks:

+ Libraries versions: Unify versions on a single file
+ Firebase Integration
+ Unit Testing
+ Logging DEBUG vs RELEASE: Obfuscate relevant information
+ Coverage Tools
+ Publish Artifact
+ Bluetooth Integration
+ Automation Testing




## Successful milestones:

+ **Module Abstraction**. A common module has been created which the rest of modules inject. All the business logic has been splitted in several modules such as launches (All information regarding SpaceX launches). A shared module has been created as a bridge with all feature modules.
+ **REST Request**: Using Ktor a GET request to a public API and retrieve data on both platforms was executed successfully.
+ **Logging REST**: Using Ktor-logging to show logs on the console was executed successfully.
+ **Logging messages**: Local implementation was required. Logs not disabled on iOS Release.
+ **Coroutines Retries**: Custom implementation has been done to retry failing REST connections.
+ **Exception Handler**: Custom implementation has been created to ensure only CustomException is sent to domain layer.
+ **Dependency Injection**: Koin was used to solve DI issue. When SDK is initialized the graph is created and no method can be called without this step.




## Issues found:

### Logging messages:
There no native logging mechanism. Actual/Expect implementation was required. Logs not disabled on iOS Release.

### CustomException on Domain Layer:
The only way to populate to domain layer Custom Exception was adding @ExperimentalStdlibApi to all classes propagating the Exception. Review in the future the compatibility.

### Dependency Injection:
The Sdk implements it's own graph using Koin. In case native apps already use any DI mechanish the contract should be modified to pass the module to application parents.




## Reference links:

+ https://github.com/touchlab/KaMPKit
+ https://github.com/AAkira/Kotlin-Multiplatform-Libraries
+ https://libs.kmp.icerock.dev/




