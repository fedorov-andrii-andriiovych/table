package ua.wwind.convention.kmp.target

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import ua.wwind.convention.util.computeValidatedNamespace

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val androidNamespace: String = project.computeValidatedNamespace(
    explicitPropertyNames = listOf("androidNamespace"),
    basePropertyName = "baseNamespace",
    subjectLabel = "Android namespace",
)

plugins {
    kotlin("multiplatform")
    // AGP 8.12.0+ Kotlin Multiplatform library plugin. Replaces `com.android.library` +
    // `androidTarget()`, which are incompatible with AGP's new DSL once Kotlin enforces it
    // (Kotlin 2.4.0+). See https://developer.android.com/kotlin/multiplatform/plugin
    id("com.android.kotlin.multiplatform.library")
}

kotlin {
    // New AGP KMP library DSL: configuration lives in `kotlin { android { } }`,
    // single-variant; `minSdk` is set directly (no `defaultConfig`).
    android {
        namespace = androidNamespace
        compileSdk = libs.findVersion("android-compileSdk").get().requiredVersion.toInt()
        minSdk = libs.findVersion("android-minSdk").get().requiredVersion.toInt()

        // Compose Multiplatform / Android resources are opt-in under the new plugin.
        androidResources {
            enable = true
        }

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}
