import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.23"
}

group = "kr.eme.semiShop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    compileOnly("kr.eme.semiMoney:SemiMoney:1.0-SNAPSHOT")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.jar {
    archivesName = "${project.name}-${project.version}.jar"
    destinationDirectory = file("d:\\minecraft\\1. 버킷 관련\\1.20.2 paper_dev2\\plugins")
    manifest {
        attributes["main-class"] = "kr.eme.semiShop.SemiShop"
    }
}