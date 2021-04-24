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

### When does the JDBC template acquire (and release) a connection, for every metohd called or once per template? Why? ####

Once per method call.

### How does the JDBC template support generic queries? How does it return objects and lists/maps of objects? ###

- JDBC Template can return each row of a ResultSet as a Map
=> query for a Map: expecting a single row => Map<String, Object> is map of column name and field value
=> query for a List: expecting multiple rows => List<Map<String, Object>>

----

### What is a transaction? What is the difference between a local and a global transaction? ###

transaction = set of tasks which take place as a single invisible action
- atomic = each unit of work is an all-or-nothing operation
- consistent = database integrity constraints are never violated
- isolated = isolating transactions from each other
- durable = committed changes are permanent

local transaction = single resource (one database)

global transaction = managed by dedicated transaction manager over multiple ressources

### Is a transaction a cross cutting concern? How is it implemented in Spring? ###

Yes, the common pattern isn PlatformTransactionManager

### Open questions (still): ###
- How are you going to define a transaction in Spring? 
- What does @Transactional do? What is the PlatformTransactionManager?
- Is the JDBC template able to participate in an existing transaction?
- What is a transaction isolation level? How many do we have and how are they ordered?
- What is @EnableTrnasactionManagement for?
- What does transaction propagation mean?
- What happens if one @Transactional annotated method is calling another @Transactional annotated method on the same object instance?
- Where can the @Transactional annotation be used? What is a typical usage if you put it at class level?
- What does declarative transaction management mean?
- What is the default rollback policy?
- How can you override it?
- What is the default rollback policy in a JUnit test, when you use the @RunWith(SpringJUnit4ClassRunner.class) in JUnit 4 or @ExtendWith(SpringExtension.class) in JUnit 5, and annotate your @Test annotated method with @Transactional?
- Why is the term "Unit of work" so important and why does JDBC AutoCommit violate this pattern?

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

