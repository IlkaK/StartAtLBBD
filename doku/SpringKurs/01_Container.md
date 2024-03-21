# Container, Dependency, and IoC #

### What is dependency injection and what are the advantages? ###

In general, Spring is a dependency injection container, also known as IoC container. That means it contains all objects and gives them whom needs them.
Only the container needs to be controlled from the outside, the objects do not need to be initialized when needed again.

Advantages of dependency injection:

- objects do not need to worry about seeing, finding or initializing each other
- decreases coupling between a class and its dependencies
- increases module reusability
- more readable code

### What is an interface and what are the advantages of making use of them in Java? ###

Den ersten Teil haben wir hier schon gemacht: [Logback Aufgabe](../JavaBuch/05_bis_11_Kapitel/Logback_Aufgabe.md)

Advantages of interfaces:

- an interface is like a contract, so a class implementing an interface guarantees in- and outcome

- with interfaces complex designs can be broken up
- dependencies between objects can be made clear

- interfaces can make the application loosely coupled

### Why are interfaces recommended for Spring beans? ###

Concrete classes also work very well as Spring beans. If you use an interface e.g. for the database layer, the implemented database class underneath can be changed easier.
Spring usage is said to be more smooth while using interfaces.


### What is meant by Application context? ###

Das haben wir bei den Begriffen schon gemacht: [Gefässe und Abhängigkeiten](./00_Terms.md)

----

### Bean ###


Jedes Objekt, welches innerhalb von einem Spring ApplicationContext erstellt, verwaltet und wieder aufgeräumt wird, ist ein Spring Bean.

Ein Bean kann auf zwei Arten kenntlich gemacht werden.

1. Annotation der Klasse mit @Component (oder eine Unterkategorie davon, z.B. @Bean) [Components](./00_Terms.md)
2. In einer Klasse, die mit @Configuration als Konfigurationsklasse gekennzeichnet ist, wird ein Objekt erzeugt und mit @Bean annotiert.


### Lifecyle ###

Es gibt drei Phasen im Bean-Lebenszyklus:
1. Bean Creation
1.1 initialization/instantiation: Das Bean wird von Spring erstellt, so wie es auch manuell instantiiert werden würde. 
1.2 Populting Properties: Spring setzt relevante Properties im Bean.
1.3-1.7 Pre-Initialization, AfterPropertiesSet, Custom Initialization, Post-Initializiation, Pre-Destroy

2. Destroy

[Referenz](https://reflectoring.io/spring-bean-lifecycle/)

### @Configuration ###

[Spring-Doku](https://docs.spring.io/spring-framework/reference/core/beans/java/basic-concepts.html)

Wenn eine Klasse mit @Configuration annotiert wird, ist ihr Hauptzweck, dass Beans in ihr definiert werden. Dort drin sind auch sogenannte inter-bean Dependencies möglich, also Beans können dort beim Iniliasieren wieder andere Beans referenzieren.

- Die @Bean Annotation wird normalerweise nur in @Configuration Klassen verwendet.

- @ComponentScan: Diese Annotation wird normalerweise in @Configuration verwendet, um die Packages anzugeben, die auf @Component Klassen gescannt werden sollen. All diese sollen von der @Configuration Klasse initialisiert werden.

- @EnableAutoConfiguration: Das bedeutet Spring(-Boot) sucht sich die Dependencies zusammen (z.B. die vom Classpath), schaut, ob diese irgendwo verwendet werden und konfiguriert diese automatisch dazu. 

[Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. For example, if HSQLDB is on your classpath, and you have not manually configured any database connection beans, then Spring Boot auto-configures an in-memory database.](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-auto-configuration.html)

- @Configuration+@EnableAutoConfiguration+@ComponentScan = [@SpringBootApplication](12_Spring_Boot_Auto_Configuration.md)


- @Controller werden verwendet im [Spring Model View Controller architecture](05_MVC.md)

- @Autowired - auf Konstruktor, statischem Feld oder get/set Methode: Autowired wird verwendet, um eine Abhängigkeit aufzuzeigen

Vorteile für den @Autowired auf dem Konstruktor: 
– You can define immutable instances by making the attributes final.
– You can define dependencies in unit tests directly when you create the instance of bean you want to test.
[@Autowired](https://laurspilca.com/comparison-field-constructor-setter-injection/)


### Can you describe the lifecycle of a Spring Bean in an Application Context? ###

Container/Spring Bean lifecycle:
1. initialization (within creation of application context)
2. usage
3. destruction

Bean initialization steps:
1. Load Bean definition
2. PostProcess Bean definition
3. Find and create its dependencies
4. Instantiate Beans (dependency injection)
5. ferorm setter injection (dependency injection)
6. BeanPostProcessor (BPP) Initializer
7. Bean ready for use


### How are you going to create an Application Context in an integration test? ###



### What is the preferred way to close an Application Context? Does Spring Boot do this for you? ### 

----

### Can you describe the following? ###
1. dependency injection using Java configuration
2. dependency injection using annotatins (@Autowired)
3. component scanning, stereotypes?
   - stereotype annotation -> component scanning checks for annotations that are themselves annotated with @Component
   - spring framework stereotype annotations are @Component, @Service, @Repository, @Controller, @RestController, @Configuration

4. scopes for Spring beans?
5. what is the default scope?
   - scope of beans per default is singleton



### Are beans lazily or eagerly instantiated by default? How do you alter this behaviour? ###

### What is a property source? How would you use @PropertySource? ###

----

### What is a BeanFactoryPostProcessor and what is it used for? When is it invoked? ###

The BeanFactoryPostProcessor can modify the definition of any bean before the objects are created.

### Why would you define a static @Bean method? ###

### What is a PropertySourcePlaceholderConfigurer used for? ###

### What is a BeanPostProcessor and how is it different to a BeanFactoryPostProcessor? ###
- What do they do?
- When are they called?

### What is an initialization method and how is it declared on  Spring bean? ###

### What is a destroy method, how is it declared and when is it called? ###

### Consider how you enable JSR-250 annotations like @PostConstruct and @PreDestroy? When and how will they get called?

### How else can you define an initialization or destruction method for a Spring bean? ###

----

### What does component-scanning do? ###

### What is the behaviour of the annotation @Autowired with regards to field injection, constructor injection and method injection? ###

### What do you have to do, if you would like to inject something into a private field? How does this impact testing? ###

### How does the @Qualifier annotation complement the use of @Autowired? ###

----

### What is a proxy object and what are the two different type of proxies Spring can create? ###

- JDK Proxy: interface based
- a Spring Proxy that has: in and out Extra Logic added to TransferServiceImpl which implements TrasnferService 

- CGlib Proxy: subclass based
- a Spring Proxy: there is Extra Logic, but indepenent of TransferServiceImpl which extends TransferService

### What are the limitations of these proxies (per type)? ###

### What is the power of a proxy object and where are the disadvantages? ### 

----

### What does the @Bean annotation do? ### 

### What is the default bean id if you only use @Bean? How can you override this? ### 

### Why are you not allowed to annotate a final class with @Configuration? ### 

### How do @Configuration annotated classes support singleton beans? ###

### Why can't @Bean methods be final either? ###

----

### How do you configure profiles? What are the possible use cases where they might be useful? ###

### Can you use @Bean together with @Profile? ###

### Can you use @Component together with @Profile? ###

### How many profiles can you have? ###

----

### How do you inject scalar / literal values into Spring beans? ###

### What is @Value used for? ###

### What is Spring Expression Language (SpEL for short)? ###

### What is the Einvornment abstraction in Spring? ###

### Where can properties in the environment come from - there are myn sources for properties - check the documentation if not sure. Spring Boot adds even more. ###

### What can you reference using SpEL? ### 

### What is the difference between $ and # in @Value expressions? ###
 
----

1 constructor injection
2. setter injection
3. @PostConstruct methods (for initializing)
4. PreDestroy (for cleanup)

- @Configuration classes <=> Factories 
  -> they crete Spring-Beans
- Spring is a Factory
