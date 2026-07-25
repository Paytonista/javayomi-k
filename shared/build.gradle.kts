plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    kotlin("plugin.serialization") version "2.2.0"
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")
            implementation("org.jetbrains.compose.material:material-icons-extended:1.7.3")
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation("io.coil-kt.coil3:coil-compose:3.5.0")
            implementation("io.coil-kt.coil3:coil-network-okhttp:3.5.0")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel:2.8.4")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.8.4")
            implementation("io.github.vinceglb:filekit-core:0.14.2")
            implementation("io.github.vinceglb:filekit-dialogs:0.14.2")
            implementation("io.github.vinceglb:filekit-dialogs-compose:0.14.2")
            implementation("io.github.vinceglb:filekit-coil:0.14.2")


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}