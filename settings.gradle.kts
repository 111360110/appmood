pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        kotlin("android") version "1.8.0" // 確保使用兼容的 Kotlin 版本
        kotlin("kapt") version "1.8.0"   // 啟用 kapt 插件處理 Room 注解
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // 添加 JitPack 儲存庫
    }
}

rootProject.name = "Mood1"
include(":app")
