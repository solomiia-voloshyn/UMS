plugins {
    java
    checkstyle
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "spring-boot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.jetbrains:annotations:23.1.0")
    implementation("org.jetbrains:annotations:20.1.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.liquibase:liquibase-core:4.18.0")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")
    testImplementation("io.rest-assured:spring-mock-mvc:4.0.0")
    implementation("org.testcontainers:testcontainers-bom:1.16.0")
    testImplementation ("org.testcontainers:junit-jupiter:1.16.0")
    implementation ("org.testcontainers:postgresql:1.16.0")
    implementation ("io.swagger:swagger-annotations:1.6.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
