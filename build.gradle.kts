plugins {
    alias(libs.plugins.springboot.dependency.management)
    alias(libs.plugins.openapi.generator)
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spotless)
}

group = "com.yonatankarp"

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot
    implementation(libs.bundles.springboot.all)

    // Kotlin
    implementation(libs.bundles.kotlin.all)

    // Persistence
    runtimeOnly(libs.postgresql)
    implementation(libs.bundles.persistence.support.all)

    // Tests
    testImplementation(platform(libs.testcontainers.bom))
    testImplementation(libs.bundles.test.all)
//    {
//        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
//    }
}

tasks {
    jar {
        enabled = false
    }

    build {
        finalizedBy(spotlessApply)
    }

    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(21)
}

spotless {
    kotlin {
        target(
            fileTree(projectDir) {
                include("**/*.kt")
                exclude(
                    "**/.gradle/**",
                    "**/build/generated/**"
                )
            }
        )
        // see https://github.com/shyiko/ktlint#standard-rules
        ktlint("1.5.0")
    }
}

val tasksDependencies = mapOf(
    "spotlessKotlin" to listOf("processResources", "compileKotlin"),
)

tasksDependencies.forEach { (taskName, dependencies) ->
    tasks.findByName(taskName)?.dependsOn(dependencies)
}
