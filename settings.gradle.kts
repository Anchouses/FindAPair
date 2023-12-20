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

include(":common-ui")

include(":menu-impl")
include(":menu-api")

include(":game-impl")
include(":game-api")

include(":end-api")
include(":end-impl")


