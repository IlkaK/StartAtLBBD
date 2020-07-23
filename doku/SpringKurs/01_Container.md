# Container, Dependency, and IoC #

### 1. What is dependency injection and what are the advantages? ###

In general, Spring is a dependency injection container, also known as IoC container. That means it contains all objects and gives them whom needs them.
Only the container needs to be controlled from the outside, the objects do not need to be initialized when needed again.

Advantages of dependency injection:

- objects do not need to worry about seeing, finding or initializing each other
- decreases coupling between a class and its dependencies
- increases module reusability
- more readable code


### 2. What is an interface and what are the advantages of making use of them in Java? ###

Den ersten Teil haben wir hier schon gemacht: [Logback Aufgabe](../JavaBuch/05_bis_11_Kapitel/Logback_Aufgabe.md)

Advantages of interfaces:

- an interface is like a contract, so a class implementing an interface guarantees in- and outcome

- with interfaces complex designs can be broken up
- dependencies between objects can be made clear

- interfaces can make the application loosely coupled

### 3. Why are interfaces recommended for Spring beans? ###

Concrete classes also work very well as Spring beans. If you use an interface e.g. for the database layer, the implemented database class underneath can be changed easier.
Spring usage is said to be more smooth while using interfaces.
