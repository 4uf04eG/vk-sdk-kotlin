# Change log

Version 0.0.6 *(2020-09-06)*
----------------------------
* Kotlin `1.4.0` support
* JS artifact (`nodejs`) supported again
* Several small minor fixes

Version 0.0.6-1.4.0-rc *(2020-08-01)*
----------------------------
* Migrate to Kotlin `1.4.0-rc`, update dependencies, solve issues
* Add `json` to constructors everywhere to be able to provide custom configuration
* Several small minor fixes
* JS artifact (`nodejs`) is not available for common http client due to the yarn issue

Version 0.0.5 *(2020-05-20)*
----------------------------

* ktor-based http client is not abstract anymore, but still `open`. Provide client in constructor or override the method.

Version 0.0.4 *(2020-05-18)*
----------------------------

* Made some client methods public

Version 0.0.3 *(2020-05-17)*
----------------------------

* Added method for creating VkApiClient from code (authorization code flow)
* Small refactoring
* Small documentation changes

Version 0.0.2 *(2020-04-25)*
----------------------------

* Added JS support
* Added methods for asynchronous uploading of attachments
* Changed default behavior of `execute` batch queue: default numbers of requests per second is now `3`, but earlier batch queue was used by defautl and was disables, so error occurred
* Examples updates & documentation 

Version 0.0.1 *(2020-04-24)*
----------------------------

First release.

Version `vk-bot-java-sdk` *(2017-07-30)*
----------------------------

Deprecated and moved to the branch [https://github.com/vksdk/vk-sdk-kotlin/tree/old-vk-bot-java-sdk](https://github.com/vksdk/vk-sdk-kotlin/tree/old-vk-bot-java-sdk)