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
    }
}

rootProject.name = "Find a Pair"
include(":app")
include(":commom-ui")
include(":menu-impl")
include(":menu-api")
include(":game-impl")
include(":lib")
include(":end-api")
include(":end-impl")
