
plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.allin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.allin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("androidx.fragment:fragment:1.3.6")
    runtimeOnly("com.google.android.material:material:1.3.0-alpha03")
    implementation ("com.github.bumptech.glide:glide:4.14.2@aar")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.google.android.material:material:1.1.0")

    implementation ("androidx.viewpager2:viewpager2:1.1.0-alpha01")
    implementation ("com.arthenica:mobile-ffmpeg-full:4.4.LTS")
}