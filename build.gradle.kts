plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.trueangle.lambda)
    alias(libs.plugins.git.versioning)
    alias(libs.plugins.ksp)
    alias(libs.plugins.mokkery)
}

group = "de.stefan_oltmann.smarthome.alexaskill"
version = "0.1"

gitVersioning.apply {

    refs {
        tag("(?<version>.*)") {
            version = "\${ref.version}"
        }
    }

    rev {
        version = "\${commit.short}"
    }
}

repositories {
    mavenCentral()
}

kotlin {

    listOf(
        linuxArm64()
    ).forEach {
        it.binaries {
            executable {
                entryPoint = "de.stefan_oltmann.smarthome.alexaskill.main"
                // freeCompilerArgs += listOf("-Xallocator=mimalloc")
            }
        }
    }

    sourceSets {
        nativeMain.dependencies {

            implementation(libs.kotlinxSerializationJson)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.curl)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.trueangle.lambda.runtime)
            implementation(libs.trueangle.lambda.events)
        }

        nativeTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

buildLambdaRelease {
    architecture.set(Architecture.LINUX_ARM64)
}
