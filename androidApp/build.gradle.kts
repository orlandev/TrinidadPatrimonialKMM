plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.inmersoft.trinidadpatrimonialkmm.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        jniLibs {
            excludes += setOf("META-INF/licenses/**")
        }
        resources {
            excludes += setOf("META-INF/licenses/**", "META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }
}



dependencies {
    implementation(project(":shared"))
    implementation ("androidx.core:core-ktx:1.7.0")

    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.runtime)
    implementation(Compose.activity)
    implementation(Compose.uiGraphics)
    implementation(Compose.foundationLayout)
    implementation(Compose.material)
    implementation(Compose.materialIconsExtended)
    implementation(Compose.navigation)
  //  implementation(Compose.paging)
    implementation(Compose.coilCompose)

    debugImplementation(Compose.uiTooling)

    //Compose Material 3
    implementation(Compose.material3)

/*

    //IContent
    implementation("com.github.orlandev:icontent:1.0.26")

    //GMap
    implementation("com.github.orlandev:gmap:0.0.12")
*/


//Accompanist

    implementation(Accompanist.placeholderMaterial)
  //  implementation(Accompanist.flowLayout)
    implementation(Accompanist.swipeRefresh)
    implementation(Accompanist.insets)
    implementation(Accompanist.systemuiController)
    implementation(Accompanist.pager)
    implementation(Accompanist.pagerIndicators)
    implementation(Accompanist.navigationAnimation)

    implementation("androidx.appcompat:appcompat:1.4.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(
        "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    )

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core:1.3.0")
    testImplementation("org.robolectric:robolectric:4.4")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose}")

    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.compose}")
}