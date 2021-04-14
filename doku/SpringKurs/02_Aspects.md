# Aspect oriented programming #

### What is the concept of AOP? Which problem does it solve? What is a cross-cutting concern? ###

- AOP enables modularization of cross-cutting concerns
- The code for cross-cutting concerns is all in a single place.
- Cross-cutting concern: generic functionality that is needed in many places in your application

### Three typical cross cutting concerns ###

- Logging and Tracing
- Transaction Management
- Security

### Two problems when solving cross-cutting concerns without AOP ###

- code tangling: coupling of concerns
- code scattering: same concern spread across modules

### What is a pointcut, join point, advice, aspect, weaving? ###

- pointcut = expression that selects one or more join points
- join point = a point in the execution of a program such as a method call or exception thrown
- advice = code to be executed at each selected join point
- aspect = module that encapsulates pointcuts and advice
- weaving = technique by which aspects are combined with main code


### How does Spring solve (implement) a cross-cutting concern? ###

- Spring uses proxy objects for method invocation interception
- the proxy objects wrap the original bean and interecepts the method invocations as specified by the set of pointcuts defined by the cross-cutting concern

### Which are the limitation of the two proxy types? ###

- JDK dynamic proxy: proxies are created at runtime is the default
- CGLIB proxy: generates subclass if class does not implement an interface, can be enforced @Enable AspectJAutoProxy(proxyTargetClass=true)
- both cannot: invocation of advices methods on self

### What visibility must Spring bean methods have to be proxied using Spring AOP? ###

- JDK dynamic proxies: public
- CGLIB proxies: public and protected

### How many advice types does Spring support? ###

- before, after returning, after throwing, after, around

### Which two advices can you use if you would like to try and catch exceptions? ###

- around and after throwing

### What do you have to do to enable the detection of the @Aspect annotation? ###

### What does @EnableAspectJAutoProxy do? ###

### If shown pointcut expressions, would you understand them? ###

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