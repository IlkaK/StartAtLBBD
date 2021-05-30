# Spring Boot Auto Configuration #

### How does Spring Boot know what to configure? ###

Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies which are added. E.g. if hsqldb is in classpath and no db connection beans are configured manually, Spring Boot auto configures an in-memory DB.

### What does @EnableAutoConfiguration do? ###

Spring Boot automatically creates the beans it thinks you need. The configuration of beans is based on: 
- contents of the classpath
- porperties you have set
- beans already defined (or not defined)

### What does @SpringBootApplication do? ###

It includes @SpringBootConfiguration, @ComponentScan und @EnableAutoConfiguration.

### Does Spring Boot do component scanning? Where does it look by default? ###

Yes, the annotation @ComponentScan is included in @SpringBootApplication. Per default Spring scans the current package and all of its sub-packages. You can also give a different root package for scanning or a list of it (e.g. @SpringBootApplication(scanBasePackage="com.example")

### How are DataSource and JdbcTemplate auto-configured? ###

If an embedded DB implementation is in classpath, it sets up the DataSource automatically. If spring-jdbc.jar is in classpath and DataSource bean is defined, it creates a JDBC Template. 

### What is spring.factories for? ###

It lists the AutoConfiguration used by Boot. It is read by @EnableAutoConfiguration. The auto-configuration classes processed after explicitly created beans are defined.

### How do you customize Spring auto configuration? ###

1. Set some of Spring Boots properties. (e.g. spring-datasource)
2. Explicitly define beans yourself so Spring Boot won't.
3. Explicitly disable some auto-configuration
4. Change dependencies

### What are the examples of @Condition annotations? How are they used? ###

@Condition annotation allows conditional bean creation. Some beans are only created if other ones exist. 

examples:
- @ConidtionOnBean(name={"dataSource"})
- @ConditionOnBean(DataSource.class)
- @ConditionOnClass => if a certain class is in the classpath
- @ConditionOnProperty 
- @ConditionOnMissingBean
- @ConditionOnMissingClass
- @ConditionOnExpression => with Spring Expression Language
- @Conditional (OwnConditionClass.class)