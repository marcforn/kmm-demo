# Pending Tasks:

+ Throws CustomException instead of Exception
+ Dependency Injection: Koin, Kodein ?¿
+ Logging DEBUG vs RELEASE: Obfuscate relevant information
+ Libraries versions: Unify versions on a single file
+ Unit Testing
+ Coverage Tools
+ Publish Artifact
+ Automation Testing



# Successful milestones:

+ Module Abstraction. We have create a common module were the rest of modules inject. And we have split business logic by module. A shared module has been created as a bridge with all feature module Interactors.
+ REST Request: Using Ktor were able to do a GET request to a public API and retrieve data on both platforms.
+ Logging REST: Using Ktor-logging we were able to show logs on the console.
+ Logging messages: Local implementation was required. Logs not disabled on iOS Release.
+ Coroutines Retries: Custom implementation has been done to retry failing REST connections.
+ Exception Handler: Custom implementation has been created to ensure only CustomException is send to domain layer.



# Issues found:

### Logging messages:
There no native logging mechanism. Actual/Expect implementation was required. Logs not disabled on iOS Release.


### Custom Exception:
The only way to populate to domain layer Custom Exception was adding @ExperimentalStdlibApi to all classes propagating the Exception.


# Reference links:

+ https://github.com/AAkira/Kotlin-Multiplatform-Libraries
+ https://libs.kmp.icerock.dev/




