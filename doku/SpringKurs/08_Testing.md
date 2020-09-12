# Testing #

### Do you use Spring in a unit test? ###

Unit tests: 
- tests without Spring
- tests one unit of functionality
- keeps dependencies minimal
- isolated from the environment (including Spring)
- uses simplified alternatives for dependencies (e.g. stubs, mocks)

### What type of tests typically use Spring?  ###

- integration tests

### How can you create a shared application context in a JUnit integration test? ###

- Tests can share the same cached Application Context with annotation @ContextConfiguration
- with @DirtiesContext a new context is enforced for each test

### When and where do you use @Transactional in testing? ###

- JPA tests are transactional and rollback at the end of teach test per default
- @Transactional(propagation=Propagation.NOT_SUPPORTED)

### How are mock frameworks such as Mockito or EasyMock used? ###

1. static import of Mockito or EasyMock
2. create Mock with createMock(myClassToMock.class) or mock(mymyClassToMock.class)
3. inject the Mock object
4. train the mock or set expcected behaviour
5. test your object (using the mock)
6. verify(mock)

### How is @ContextConfiguration used? ###

- @ContextConfiguration defines the Spring configuration to use
- it points to system test configuration file(s) <-> @ContextConfiguration(classes=SystemTestConfig.class)
- @SpringJUnitConfig combines @ExtendWith(SpringExtension.class) and @ContextConfiguration
- if no config classes are given, Spring looks for @Configuration embedded in test class

### How does Spring Boot simplify writing tests? ###

- Spring Boot Testing Framework build on top of Spring Testing Framework provides a set of annoations and utilitites for testing

### What does @SpringBootTest do? ###

@SpringBootTest:
- automatically searches for @SpringBootConfiguration
- creates the ApplicationContext used in the tests via SpringApplication

### How does @SpringBootTest interact with @SpringBootApplication and @SpringBootConfiguration? ###

- a Spring Boot application is just a SpringApplicationContext