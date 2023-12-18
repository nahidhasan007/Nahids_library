import com.android.sdklib.computeFullReleaseName

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.example.demo_library"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
publishing {
    publications {
        create<MavenPublication>("demo_library") {  // looks like the name `test-didactic-googles` can be anything.
            run {
                groupId = "com.example"
                artifactId = "demo_library"
                version = "1.0.0"
                artifact("C:\\Users\\USER.ST-SHAFAYAT\\demo\\demo-library\\build\\outputs\\aar\\demo_library-release.aar")
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/nahidhasan007/Nahids_library")
            credentials {
                username = "nahidhasan007"//githubProperties.get("gpr.usr") as String? ?: System.getenv("GPR_USER")
                password = "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"//githubProperties.get("gpr.key") as String? ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}