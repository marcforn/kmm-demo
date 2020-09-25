# Pending Tasks:

+ Dependency Injection: Koin, Kodein ?¿
+ Logging library: Nipper, Klogging ?¿ ***
+ Logging DEBUG vs RELEASE: Obfuscate relevant information
+ Libraries versions: Unify versions on a single file
+ Throws CustomException instead of Exception
+ Coroutines retries
+ Unit Testing
+ Coverage Tools
+ Publish Artifact
+ Automation Testing



# Successful milestones:

+ Module abstraction. We have create a common module were the rest of modules inject. And we have split business logic by module. A shared module has been created as a bridge with all feature module Interactors.
+ REST request: Using Ktor were able to do a GET request to a public API and retrieve data on both platforms
+ Logging REST: Using Ktor-logging we were able to show logs on the console.
+ Logging messages: Local implementation was required. Logs not disabled on iOS Release



# Issues found:

### Logging messages:
There no native logging mechanism. Actual/Expect implementation was required. Logs not disabled on iOS Release.



# Important links:

+ https://github.com/AAkira/Kotlin-Multiplatform-Libraries
+ https://libs.kmp.icerock.dev/




