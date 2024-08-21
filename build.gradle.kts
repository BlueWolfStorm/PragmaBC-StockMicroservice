plugins {
	java
	jacoco
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
	id("com.diffplug.spotless") version "7.0.0.BETA1"
}

group = "com.pragma"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

// Dependencies Values
val jimmerVersion = "0.8.157"
val mapStructVersion = "1.5.5.Final"
val openApiVersion = "1.6.9"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	//ORM
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	//Map Struct
	implementation("org.mapstruct:mapstruct:${mapStructVersion}")
	annotationProcessor("org.mapstruct:mapstruct-processor:${mapStructVersion}")

	//OpenAPI
	implementation("org.springdoc:springdoc-openapi-ui:${openApiVersion}")

}

tasks.test{
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
