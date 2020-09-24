# Pending Tasks:

+ Dependency Injection: Koin, Kodein ?¿
+ Logging library: Nipper, Klogging ?¿
+ Libraries versions: Unify versions on a single file
+ Unit Testing
+ Coverage Tools
+ Automation Testing



# Successful milestones:

+ REST request: Using Ktor were able to do a GET requet to a public API and retrieve data on both platforms
+ Logging REST: Using Ktor-logging we were able to show logs on the console.
+ Module abstraction. We have create a common module were the rest of modules inject. And we have splitted business logic by module. A shared module has been created as a bridge with all feature module Interactors.



# Issues found:

### Request Logging [SOLVED]:
On iOS response BODY can not be shown as there's a frozen error. The only logger that works is SIMPLE, with HEADERS logs. Check common Module. An alternative could be checking Okhttp.




