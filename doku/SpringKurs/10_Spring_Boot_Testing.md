# Spring Boot Testing #

### When do you want to use @SpringBootTest annotation? ###

- @SpringBootTest is an alternative to the standard spring-test @ContextConfiguration annotation when you need SpringBoot features
- it creates the Application context used in a your tests through SpringApplication
- it will not start a server, but use the webEnvironment attribute to refine how your tests run

### What does @SpringBootTest auto-configure? ###

- automatically searches for @SpringBootConfiguration
- an alternative to @ContextConfiguration

### What dependencies does spring-boot-starter-test brings to the classpath? ###

Testing dependencies: JUnit, SpringTest and SpringBootTest (testing annotations, integration test support), AssertJ, Hamcrest, Mockito, JSONassert, JsonPath

### How do you perform integration testing with @SpringBootTest for a web application? ###
 
 Spring Framework includes a dedicated test module for integration testing. It has a dependency to org.springframework:springtest or spring-boot-starter-test. The attribute webEnvironment can be used to start a server (random-port/defined-port)
 
### When do you want to use @WebMvcTest? What does it auto-configure? ###

- provides first-class support for testing Spring MVC code
- process requests throught Dispatcher Servlet
- does not require Web container to test
- @WebMvcTest auto-configures SpringMVC infrastructure

### What are the differences between @MockBean and @Mock? ###

- @Mock => from Mockito framework, use it when Spring context is not needed
- @MockBean => from SpringBootFramework,use it when Spring context is needed, it creates a new mock bean when it is not present in the Spring context or replaces a bean with a mock bean when it is present

### When do you want @DataJpaTest for? What does it auto-configure? ###

- testing JPA Applications
- it scans for @Entity classes and configures SpringDataJpa repositories 