# Spring Boot Intro #

### What is Spring Boot? ###

- opinionated: guides into their way of doing something
- runtime for Spring Projects / opinionated Defaults / Configurations
- handles low-level, predictable setup 
- supports different project types

### What are the advantages of Spring Boot? ###

- easy to integrate with Spring Ecosystem like Spring JDBC/ORM/Data/Security
- lots of plugins for developing, testing, embedded and in-memory DB
- provides embedded http servers and CLI (command line interfaces)

### Why is it opinionated? ###

- uses sensible defaults (opinions), mainly based on classpath
- e.g. sets up a DataSource if embedded DB implementation is on classpath

### What thins affect what Spring Boot sets up? ###

- settings in properties, annotations, classpath

### What is a Spring Boot starter POM? Why is it useful? ###

spring-boot-starter-parent:
- defines properties for dependencies (e.g. spring version)
- defines versions of key dependencies (dependency Management internally)
- definies Maven plugins
- sets up Java version

- other dependencies can be transitive (implizite Abhängigkeit) and multi-coordinated
- e.g. spring-boot-starter, spring-boot-starter-test
- versions are defines in parent

- common Java enterprise frameworks as Starter-POMs: spring-boot-starter-jdbc/data-jpa/web/batch

### Spring Boot supports both properties and YML files. Would you recognize and understand them, when you saw them? ###

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

### Can you control logging with Spring Boot? How? ###

- logback is enabled by default
- logging can be configured in application.properties/yml
- configuration of: log level, log format, console output, file, log groups
- enforcing another logging system is possible => org.springframework.boot.logging.LoggingSystem

### Where does Spring Boot look for properties by default? ###

1. /config subdirectory of working directory
2. working directory
3. config package in classpath
4. classpath root

### How does Spring Boot look for property file by default? ###

- application_{profile}.properties 
- in yml: spring: profiles: <profiles>

### How do you define profile specific property files? ###

- application.{profile}.properties  vs. yml => spring: profiles: <profile>

### How do you access the properties defined in the property files? ###

- @ConfigurationProperties on dedicated bean => giving the prefix there, e.g. "rewards.client"
- with @EnableConfigurationProperties on configuration class => autoinject the bean
- @ConfigurationProperties beans utilize relaxed bindings (client-connection, clientConnection, client_connection, CLIENTCONNECTION)

### What properties do you have to define in order to configure external MySQL? ###

- spring.datasource.url = jdbc:myscl://localhost/test => must be set, otherwise Spring Boot auto-configures an embedded database
- spring.datasource.username = dbuser
- spring.datasource.passsword = dbpass
- spring.datasource.driver-class-name = com.mysql.jdbc.driver => Spring Boot can detect it from the database url for most databases


### How do you configure default schema and initial data? ###

- File schema.sql and file data,sql => src/main/resources => Spring Boot automatically lookg ans runs those two files
- or spring.datasource.schema = xyz and spring.datasource.data = abc => in application.properties

### What is a fat FAR/JAR? How is it different from the original JAR? ###

- fat jar (fully executable jar) => binary executable for UNIX type systems
- can be run directly from command line
- contains all necessary dependencies

- normal jar: archive with class files and associated metadata and resources

### What is the difference between an embedded container and a WAR? ###

1. WAR: Server site Java apps normally run within a container. The traditional way to package the apps for distribution is to bundle a WAR file.  A WAR is a zip archive with standard directory layout which contains all libraries and application-level dependencies needed at runtime. It can be deployed to server container (e.g. Tomcat, Jetty, JBoss etc)

2. Embedded container: Java apps are packaged for command line execution like any normal app, rather than deployed to a container. An embedded container is deployed within the application itself. 

Spring Boot runs a standalone jar with an embedded servlet container or as a WAR file inside a container.

### What embedded containers does Spring Boot support? ###
