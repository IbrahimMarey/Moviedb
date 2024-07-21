plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
    alias(libs.plugins.kotlin.serialization)
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.moviedb"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviedb"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val androidXVersion by extra("1.0.0")
val androidXTestCoreVersion by extra("1.4.0")
val androidXTestExtKotlinRunnerVersion by extra("1.1.3")
val androidXTestRulesVersion by extra("1.2.0")
val androidXAnnotations by extra("1.3.0")
val appCompatVersion by extra("1.4.0")
val archLifecycleVersion by extra("2.4.0")
val archTestingVersion by extra("2.1.0")
val coroutinesVersion by extra("1.5.2")
val cardVersion by extra("1.0.0")
val dexMakerVersion by extra("2.12.1")
val espressoVersion by extra("3.4.0")
val fragmentKtxVersion by extra("1.4.0")
val hamcrestVersion by extra("1.3")
val junitVersion by extra("4.13.2")
val materialVersion by extra("1.4.0")
val recyclerViewVersion by extra("1.2.1")
val robolectricVersion by extra("4.5.1")
val rulesVersion by extra("1.0.1")
val swipeRefreshLayoutVersion by extra("1.1.0")
val timberVersion by extra("4.7.1")
val truthVersion by extra("1.1.2")

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    //img
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Compose Navigation
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)


    //Unit Test

    // Dependencies for local unit tests
    testImplementation ("junit:junit:$junitVersion")
    testImplementation ("org.hamcrest:hamcrest-all:$hamcrestVersion")
    testImplementation ("androidx.arch.core:core-testing:$archTestingVersion")
    testImplementation ("org.robolectric:robolectric:$robolectricVersion")

    // AndroidX Test - JVM testing
    testImplementation ("androidx.test:core-ktx:$androidXTestCoreVersion")
    //testImplementation "androidx.test.ext:junit:$androidXTestExtKotlinRunnerVersion"

    // AndroidX Test - Instrumented testing
    androidTestImplementation ("androidx.test.:$androidXTestExtKotlinRunnerVersion")
    androidTestImplementation ("androidx.test.espresso:espresso-core:$espressoVersion")

    //Timber
    implementation ("com.jakewharton.timber:timber:5.0.1")

    // hamcrest
    testImplementation ("org.hamcrest:hamcrest:2.2")
    testImplementation ("org.hamcrest:hamcrest-library:2.2")
    androidTestImplementation ("org.hamcrest:hamcrest:2.2")
    androidTestImplementation ("org.hamcrest:hamcrest-library:2.2")


    // AndroidX and Robolectric
    testImplementation ("androidx.test.ext:junit-ktx:$androidXTestExtKotlinRunnerVersion")
    testImplementation ("androidx.test:core-ktx:$androidXTestCoreVersion")
    testImplementation ("org.robolectric:robolectric:4.8")

    // InstantTaskExecutorRule
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")

    //kotlinx-coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")


    // Dependencies for Android instrumented unit tests
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")


    //Mockito
    testImplementation ("org.mockito:mockito-core:3.+")
    testImplementation ("org.mockito:mockito-inline:3.+")
    testImplementation ("junit:junit:4.+")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:4.0.0")


}

kapt{
    correctErrorTypes = true
}