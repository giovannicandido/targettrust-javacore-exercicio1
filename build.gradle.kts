plugins {
    id("java")
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "br.com.targettrust.javacore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.4.1")


}

tasks.test {
    useJUnitPlatform()
}