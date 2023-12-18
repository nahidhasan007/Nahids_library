pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url =uri("https://jitpack.io") }
        maven {
            name = "GitHubPackages"
            /*  Configure path to the library hosted on GitHub Packages Registry
             *  Replace UserID with package owner userID and REPOSITORY with the repository name
             *  e.g. "https://maven.pkg.github.com/enefce/AndroidLibrary-GPR-KDSL"
             */
            //url = uri("https://maven.pkg.github.com/UserID/REPOSITORY")
            url = uri("https://maven.pkg.github.com/nahidhasan007/Nahids_library")
            credentials {
                username = "nahidhasan007"//githubProperties.get("gpr.usr") as String? ?: System.getenv("GPR_USER")
                password = "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"//githubProperties.get("gpr.key") as String? ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}



rootProject.name = "DemoLibrary"
include(":app")
include(":demo-library")
