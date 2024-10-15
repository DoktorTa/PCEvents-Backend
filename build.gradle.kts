
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    id("com.palantir.docker") version "0.35.0"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.cio.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.cio)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}

docker {
    name = "${project.group}/${project.name}:${project.version}"
    files("build/libs/pc-event.backend-0.0.1.jar")
    buildArgs(mapOf("JAR_FILE" to "pc-event.backend-0.0.1.jar"))
}
