# VK SDK Kotlin
![cover](docs/images/cover.png)

Unofficial VK.com SDK, written in Kotlin.
Based on Kotlin Multiplatform project, but has Java-friendly API.

See the documentation: https://vksdk.github.io/vk-sdk-kotlin

## Minimal example of the echo-chatbot

### Kotlin
```kotlin
// From here: https://vk.com/club151083290 take the ID
val groupId = 151083290

// Read more: https://vk.com/dev/access_token
val accessToken = "abcdef123456..."

// There are two http clients available for now: 
// JVM-only OkHttp-based
// and common ktor-based
val vkHttpClient = VkOkHttpClient()

val client = VkApiClient(groupId, accessToken, VkApiClient.Type.Community, VkSettings(vkHttpClient))

client.onMessage { messageEvent ->
    client.sendMessage {
        peerId = messageEvent.message.peerId
        message = "Hello, World!"

        // You can use stickers, replies, location, etc.
        // All of the message parameters are supported.
    }.execute()
}

client.startLongPolling()
```

### Java
```java
int groupId = 151083290;
String accessToken = "abcdef123456...";
HttpClient vkHttpClient = new VkOkHttpClient();

VkApiClient client = new VkApiClient(groupId, accessToken, VkApiClient.Type.Community, new VkSettings(vkHttpClient));

client.onMessage(event -> {
    new Message()
        .peerId(event.getMessage().getPeerId())
        .text("Hello, world!")
        .sendFrom(client)
        .execute();
});

client.startLongPolling();
```

## Features
The primary goal of the library is to cover most of the possible needs but in an abstract way.
You can't find here a hundred of pre-defined data classes for each API method, but you can write the highly customizable solution in most convenient way.

- Supported platforms: JVM, JS, darwin (iOS, macOS, tvOS, watchOS), mingwX64 (Windows), linuxX64
- Big and detailed examples: Multiplatform project (iOS & Android), Kotlin project, Java-only project. See the `examples` directory and the [documentation](https://vksdk.github.io/vk-sdk-kotlin/examples/).
- Written in Kotlin, but has JVM-friendly API with methods overloading, static methods, etc.
- Modularized and highly customizable: use pre-defined HTTP-clients or write your own; combine API calls, make queues or calls lists, etc.
- [Bots Long Poll API](https://vk.com/dev/bots_longpoll)
  - Event is a data class `MessageNew` for `message_new` event
  - and the [`JsonElement`](https://github.com/Kotlin/kotlinx.serialization) for all the other events
- Batch requests queue using [execute](https://vk.com/dev/execute) method under the hood: make up to 75+ requests per second and don't think about the [VK API limitations](https://vk.com/dev/api_requests?f=Limits%20and%20recommendations)
  - Putting into batch requests queue is optional, but done by default for asynchronous requests
  - Synchronous calls always sent immediately
- API calls:
  - Synchronous
  - Asynchronous (using callbacks)
  - Using [Kotlin Coroutines Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) wrapper
- [`messages.send`](https://vk.com/dev/messages.send): use DSL for sending messages and building keyboards. All method capabilities are covered.
  - Attach files in a couple of lines of code, using a file from disk, URL, etc.
  
## Install
Library is uploaded to the Maven Central Repository.

For Gradle 6.0+ or with metadata enabled, add the dependencies in this way:
```groovy
// core module is required
implementation "com.petersamokhin.vksdk:core:$vkSdkVersion"

// One of the HTTP clients is also required.
// You can use pre-defined OkHttp-based client, but only for JVM.
implementation "com.petersamokhin.vksdk:http-client-jvm-okhttp:$vkSdkVersion"

// Or else you can use the common HTTP client, which is based on ktor 
// and available for all of the platforms, including JVM.
// In this case, you also should specify the ktor engine.
implementation "com.petersamokhin.vksdk:http-client-common-ktor:$vkSdkVersion"
```

Otherwise, add `enableFeaturePreview("GRADLE_METADATA")` to `settings.gradle` or else you should specify the platform.
Example for JVM:
```groovy
implementation "com.petersamokhin.vksdk:core-jvm:$vkSdkVersion"
implementation "com.petersamokhin.vksdk:http-client-common-ktor-jvm:$vkSdkVersion"

// and OkHttp-based client is already JVM-only
implementation "com.petersamokhin.vksdk:http-client-jvm-okhttp:$vkSdkVersion"
```

## Limitations
#### Unsupported platforms
- `linuxArm32Hfp`, `linuxMips32`
  - https://github.com/Kotlin/kotlinx.coroutines/issues/855

#### Unsupported functionality
- Attachment of a file (i.e. access to filesystem) is available only for darwin and JVM. Other platform implementations may be in todo. 
- Synchronous calls for `js` platform
  - https://github.com/Kotlin/kotlinx.coroutines/issues/195#issuecomment-354458878

## 3rd party
- Kotlin ([coroutines](https://github.com/Kotlin/kotlinx.coroutines), [serialization](https://github.com/Kotlin/kotlinx.serialization), [dokka](https://github.com/Kotlin/dokka))
- [ktor](https://github.com/ktorio/ktor) client
- [gradle-maven-publish-plugin](https://github.com/vanniktech/gradle-maven-publish-plugin)
- [OkHttp](https://github.com/square/okhttp)
- [Stately](https://github.com/touchlab/Stately)
- SwiftUI for iOS app for the multiplatform example

## License
See the [License](https://github.com/vksdk/vk-sdk-kotlin/blob/master/LICENSE)