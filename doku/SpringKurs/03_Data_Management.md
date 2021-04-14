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

###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

###  ###

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

