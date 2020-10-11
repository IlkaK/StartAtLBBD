# Security #

### What are authentication and authorization? Which one comes first? ###

1. authentication => who is there?
2. authorization => what is the user allowed to do?

### Is security a cross cutting concern? How is it implemented finally? ###

Yes, it is a cross cutting conern. Those are concerns applicable through the application.

Security context: authentication manager and security interceptor

### What is the delegating filter proxy? ###

DelegatingFilterProxy is a servlet filter that allows passing control to filter classes that have access to the SpringApplicationContext. 

[Servlet auf Wikipedia](https://de.wikipedia.org/wiki/Servlet)

### What is the security filter chain? ###

Spring Security maintains a filter chain internally where each of the filters has a particular responsibility and filters are added / removed from the configuration dependency on which services are required.

### What is the security context? ###

The security context is used to store the details of the currently authenticated user, also known as principle.

### What does the `**` pattern in antMatcher or mvcMatcher do? ###

It is authorizing URLs. `**` matches any path under given part, e.g. /admin/`**`

### Why is the usagge of mvcMatcher recommended over antMatcher? ###

newer API, less errorprone

### Does Spring Security support password hashing? ###

yes

### What is salting? ###

- Using a salt string to make encryption stronger.
- salt is prepended to password before hashing

### Why do you need method security? What type of object is typically secured at the method level (think of its purpose not its Java type)? ###

- to reuse code without thinking about security issues 
- to integrate with a web service easily 
- to be sure about security when you don't trust the upper layers' security mechanisms. Frontend and backend are normally disconnected, so the backend needs to ensure security as well.
- it is the lowest available level for security

In an MVC architecture each method on a Controller class is a separate action. In most MVC frameworks privileges can be assigned at both the method level and the class level. That would mean I can apply an attribute/annotation at the class level and the corresponding role would be required for every action in that controller.
In respects to more fine grained control for role based access consider this:
  - It's convenient to group all actions around a resource together. I.e. your Create/Read/Update/Delete (CRUD) actions for articles, accounts, etc. This makes REST style APIs easier to write and maintain.
  - Many systems have different credentials/roles required for Create/Update/Delete actions than they do for Read actions.
  - If all user account actions are in one controller, you want to allow anyone to log in, but only certain people to create new accounts or assign roles.

[Inhalte von der Diskussion auf Software Engineering](https://softwareengineering.stackexchange.com/questions/63549/why-do-we-need-method-level-security/63563#:~:text=Method%20level%20security%20is%20useful,security%20isn't%20relevant)

### What do @PreAuthorized and @RolesAllowed do? What is the difference between them? ###

- @PreAuthorize, @RolesAllowed and @Secured are annotations which allow to configure method security (either applied on class or method level).

@PreAuthorize:
- @PreAuthorize annotation allows to specify access constraints to a method using the Spring Expression Language (SpEL). 
These constraints are evaluated prior to the method being executed and may result in execution of the method being denied if the constraints are not fulfilled. The @PreAuthorize annotation is part of the Spring Security framework.
- @PreAuthorize is another Spring specific annotation. You can perform a lot more powerful operations with @PreAuthorize using SpEL. You can write expressions the limit method invocation based on the roles/permissions, the current authenticated user, and the arguments passed into the method.
- In order to be able to use @PreAuthorize, the prePostEnabled attribute in the @EnableGlobalMethodSecurity annotation needs to be set to true: `@EnableGlobalMethodSecurity(prePostEnabled=true)`

@RolesAllowed:
- @RolesAllowed annotation has its origin in the JSR-250 Java security standard. This annotation is more limited than the @PreAuthorize annotation because it only supports role-based security.
In order to use the @RolesAllowed annotation the library containing this annotation needs to be on the classpath, as it is not part of Spring Security.
- In order to use the @RolesAllowed annotation the library containing this annotation needs to be on the classpath, as it is not part of Spring Security. In addition, the jsr250Enabled attribute of the @EnableGlobalMethodSecurity annotation need to be set to true:
`@EnableGlobalMethodSecurity(jsr250Enabled=true)`

@Secured:
- @Secured annotation is a legacy Spring Security 2 annotation that can be used to configure method security. 
It supports more than only role-based security, but does not support using Spring Expression Language (SpEL) to specify security constraints. It is recommended to use the @PreAuthorize annotation in new applications over this annotation.
- @Secured and @RolesAllowed perform identical functionality in Spring. The difference is that @Secured is a Spring specific annotaiton while @RolesAllowed is a Java standard annotation (JSR250). Neither one of these annotation support SpEL.
- Support for the @Secured annotation needs to be explicitly enabled in the @EnableGlobalMethodSecurity annotation using the securedEnabled attribute: `@EnableGlobalMethodSecurity(securedEnabled=true)`

`@Secured(["Role_Viewer","Role_Editor"])` <=> `@PreAuthorized("hasRole('Role_Viewer') or hasRole('Role_Editor')")` <=> `@RolesAllowed(["Role_Viewer","Role_Editor"])`

[Inhalte von der Diskussion auf Stackoverflow](https://stackoverflow.com/questions/43961625/rolesallowed-vs-preauthorize-vs-secured#:~:text=Security%20Annotations,all%20methods%20in%20the%20class.)