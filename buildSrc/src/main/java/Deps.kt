object Deps {
    const val apolloRuntime = "com.apollographql.apollo3:apollo-runtime:${Versions.apollo}"
    const val apolloNormalizedCache =
        "com.apollographql.apollo3:apollo-normalized-cache:${Versions.apollo}"
    const val multiplatformPaging =
        "io.github.kuuuurt:multiplatform-paging:${Versions.multiplatformPaging}"

    const val napierLoggin = "io.github.aakira:napier:${Versions.napierVersion}"

    object KTor {
        const val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
        const val ktorClientOKHTTP = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
        const val ktorClientSerialization =
            "io.ktor:ktor-client-serialization:${Versions.ktorVersion}"
        const val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"
        const val ktorClientAuth = "io.ktor:ktor-client-auth:${Versions.ktorVersion}"
        const val ktorClientAndroid = "io.ktor:ktor-client-android:${Versions.ktorVersion}"
        const val ktorClientIOS = "io.ktor:ktor-client-ios:${Versions.ktorVersion}"
    }

    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerializationJson}"

    object Kotlinx {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
    }



}