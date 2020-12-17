# Spring Data JPA #

### @Repository ###

- @Repository is a Spring annotation that indicates that the decorated class is a repository. A repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects. 
- @Repository is a specialization of the @Component annotation.

[Quelle](http://zetcode.com/springboot/repository/#:~:text=%40Repository%20is%20a%20Spring%20annotation,emulates%20a%20collection%20of%20objects.)

- @Repository is a stereotype. => [What is a stereotype annotation? What does that mean? in the REST chapter](07_REST.md)

- @Repository’s job is to catch persistence specific exceptions and rethrow them as one of Spring’s unified unchecked exception.

[Quelle](https://www.baeldung.com/spring-component-repository-service)

### What is a Repository interface? ###

It is an interface that defines the repository with all logical read and write operations for a specific entity.

### How do you define a Repository interface? ###

.... extends Repository <T,D>

- JpaRepository is used in [ExampleRepository](../../src/main/java/ch/spring/ExampleRepository.java)
- JpaRepository extends Repository

Type Parameters:
- T - the domain type the repository manages
- ID - the type of the id of the entity the repository manages

[Quelle](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/Repository.html?is-external=true)

In ExampleRepository T also die Entity ist ExampleDbo, ID ist UUID.

### Why is it an interface not a class? ###

Spring Data implements repositories at runtime and creates instances as Spring Beans.

### What is the naming convention for finder methods in a Repository interface? ###

- findById
- findAll
- findAllById
- find(First)By<DataMemeber><Op>
=> Op: greaterThan, NotEquals, Between, Like

e.g. findByOrderDateLessThan(Date someDate)


### How are Spring Data repositories implemented by Spring at runtime? ###

A Method interceptor intercepts all calls to the instance and routes the method to 
- the custom implementation
- (if it is a query method) a resolution mechanism that is resolving the query
- store-specific repository base class (Simple JPARepository)

### What is @Query used for? ###

@Query can be used on methods to make a jpa query or a custom query in the query language of the underlying product. 

In [ExampleRepository](../../src/main/java/ch/spring/ExampleRepository.java) verwenden wir beides.

``@Query(value = "SELECT count(id) from dbschema.t_example", nativeQuery = true)``

``@Query("select example from ExampleDbo example inner join example.exampleDetailDbo detail where detail.text = ?1")``

Bei [Bealdung](https://www.baeldung.com/spring-data-jpa-query) wird beschrieben, dass die JPA-Queries zusätzliche Attribute bieten, die man bei den native Queries selber implementieren müsste. Dazu gehört z.B. Sort und Pagination.
