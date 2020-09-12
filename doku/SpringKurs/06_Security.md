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