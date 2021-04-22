# Data Management #

### What is the difference between checked and unchecked exceptions? ###

checked exceptions: 
- force developers to handle errors
- intermediate methods must declare exceptions from all methods below => tight coupling

unchecked exceptions:
- can throw up the call hierarchy to the best place to handle it
- methods in between don't know about it

### Why does Spring prefer unchecked exceptions? ###

- better in an enterprise application => no tight coupling
- Spring always throws Runtime (unchecked) Exceptions

### What is the data access exception hierarchy? ###

Spring provides DataAccessException hierarchy.
- hides whether you are using JPA, Hibernate, JDBC
- a hierarchy of sub-exceptions
- consistent across all supported Data Access technologies
- unchecked

### How do you configure a DataSource in Spring? Which bean is very useful for development / test databases? ###

- DataSource is used for database access and configured in JDBC Template

### What is the Template design pattern and what is the JDBC template?  ###

Template design pattern: 
- widely used and useful pattern
- defines the outlet / skeleton of an algorithm
- leaves the details to specific implementations later
- hides away large amounts of boilerplate code

JDBC template:
- simplifies JDBC API
- eliminates repetitive boilerplate code
- alleviates (abmildern) common cause of bugs
- handles SQLExceptions properly

### What is a callback? ###

- some method calls are handled directly entirely by the Jdbc Template, some require the calling class to provide callback methods that contain the implementation of parts of the JDBC workflow
=> inverse of control

### What are the three JDBC Template callback interfaces that can be used with queries? What is each used for? ###

- RowCallbackHandler => processing rows of a ResultSet
- CallableStatementCreator => creates a callable Statement
- PreparedStatementCreate => creates a Prepared Statement

### Can you execute a plain SQL statement with JDBC template? ###

Yes, with the execute() method.

### When does the Jdbc Template support generic queries? How does it return objects and lists/maps of objects? ###



###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

-------

### What do you need to do in Spring if you would like to work with JPA? ###

- annotating the Persistence Context with @EnableJpaRepositories
- setting up the Entity Manager => LocalContainerEntityManagerFactoryBean
- setting up the Data Source Bean
- setting up the JPA Transaction Manager

### Are you able to participate in a given transaction in Spring while working with JPA? ###

You can access the transaction manually.

https://stackoverflow.com/questions/29343847/how-exactly-means-partecipate-in-a-given-transaction-in-spring-working-with-jpa

### Which PlatformTransactionManager(s) can you use in JPA? ###

- DataSource, JMS, JPA, JTA, WEbLogicJta, Websharehow - TransactionManager

### What do you have to configure to use JPA with Spring? How does Spring Boot make this easier? ###

- dependency: spring-boot-starter-data-jpa
- if Spring and JPA on classpath => creates a DataSource and an EntityManagerFactoryBean, also sets up JPATransactionManager

