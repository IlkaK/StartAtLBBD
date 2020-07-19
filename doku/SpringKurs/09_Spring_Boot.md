# Spring Boot Intro #

### 1. What is Spring Boot? ###

- opinionated: guides into their way of doing something
- runtime for Spring Projects / opinionated Defaults / Configurations
- handles low-level, predictable setup 
- supports different project types

### 2. What are the advantages of Spring Boot? ###

- easy to integrate with Spring Ecosystem like Spring JDBC/ORM/Data/Security
- lots of plugins for developing, testing, embedded and in-memory DB
- provides embedded http servers and CLI (command line interfaces)

### 3. Why is it opinionated? ###

- uses sensible defaults (opinions), mainly based on classpath
- e.g. sets up a DataSource if embedded DB implementation is on classpath

### 4. What thins affect what Spring Boot sets up? ###

- settings in properties, annotations, classpath

### 5. What is a Spring Boot starter POM? Why is it useful? ###

spring-boot-starter-parent:
- defines properties for dependencies (e.g. spring version)
- defines versions of key dependencies (dependency Management internally)
- definies Maven plugins
- sets up Java version

- other dependencies can be transitive (implizite Abhängigkeit) and multi-coordinated
- e.g. spring-boot-starter, spring-boot-starter-test
- versions are defines in parent

- common Java enterprise frameworks as Starter-POMs: spring-boot-starter-jdbc/data-jpa/web/batch

### 6. Spring Boot supports both properties and YML files. Would you recognize and understand them, when you saw them? ###

application.properties:
- creates a Properties Source based on these files
- profile-specific properties have convention => application_{profile}.properties
(application_local.properties, application_cloud.properties, application.properties)

application.yml:
- YAML configuration => Datenstruktur zum Darstellen von assoziativen Listen, Arrays und Einzelwerten (Skalaren)
- leichter von Menschen lesbar als XML
- Spring Boot unterstützt YAML
- Spring Boot looks for application.yml file in the same locations as application.properties
- Spring Framework and @PropertySource do not support YAML
- profile specific properties can be placed in one single file 
- "---" seperates logical files

### 7. Can you control logging with Spring Boot? How? ###

- logback is enabled by default
- logging can be configured in application.properties/yml
- configuration of: log level, log format, console output, file, log groups
- enforcing another logging system is possible => org.springframework.boot.logging.LoggingSystem

### 8. Where does Spring Boot look for properties by default? ###

1. /config subdirectory of working directory
2. working directory
3. config package in classpath
4. classpath root

### 9. How does Spring Boot look for property file by default? ###

- application_{profile}.properties 
- in yml: spring: profiles: <profiles>

