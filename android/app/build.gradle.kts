plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.savemyaccount.verificationapp"
    compileSdk = flutter.compileSdkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    signingConfigs {
        create("release") {
            storeFile = file("release-keystore.jks")
            storePassword = "mysecretpassword"
            keyAlias = "upload"
            keyPassword = "mysecretpassword"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            minifyEnabled = false
            shrinkResources = false
        }
        debug {
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

flutter {
    source = "../.."
}
