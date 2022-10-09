plugins {
    application
}

group = "ru.gamesphere"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("ru.gamesphere.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

dependencies {
    implementation(project(":models"))
    implementation("org.postgresql:postgresql:42.5.0")
    implementation("com.google.code.gson:gson:2.9.1")
}

