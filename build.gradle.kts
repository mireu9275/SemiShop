import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.23"
    id("maven-publish")
}

group = "kr.eme.semiShop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    compileOnly("kr.eme.semiMoney:SemiMoney:1.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "kr.eme.semiShop"
            artifactId = project.name
            version = project.version.toString()
            from(components["kotlin"])
        }
    }
}