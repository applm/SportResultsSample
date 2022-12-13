plugins {
    id("sportresultsample.android.library")
    id("sportresultsample.android.library.compose")
}

android {
    namespace = "com.mappl.design"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")
}