package ua.wwind.convention.kmp

// NOTE: the KMP sample-app convention used `com.android.application` together with
// `org.jetbrains.kotlin.multiplatform`, which AGP 9.0 / Kotlin 2.4.0 no longer support together
// (there is no drop-in replacement — `com.android.kotlin.multiplatform.library` is library-only).
// The sample is excluded when this fork is consumed as a library (excludeSamples=true), so this
// convention is stubbed to a no-op to keep precompiled-script-plugin accessor generation working.
// Restructuring the sample app for AGP 9 (a standalone android app module on top of a shared KMP
// module) is left for upstream.
