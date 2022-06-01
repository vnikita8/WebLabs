

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.5"))
    implementation("org.springframework.boot:spring-boot-starter:2.4.5")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.5.RELEASE")
}




