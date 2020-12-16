# Spring Data JPA #

### What is a Repository interface? ###

It is an interface that defines the repository with all logical read and write operations for a specific entity.

### How do you define a Repository interface? ###

.... extends Repository <T,D>

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

@Query can be used on methods to make a custom query in the query language of the underlying product. 
