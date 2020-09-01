# REST #

### What does REST stand for? ###

- "Re"presentational "S"tate "T"ransfer

R in Rest is the URL part, the S (state) is more important for scaling.

- Rest is an architectural style that describes best practices to expose web services over HTTP
- uses HTTP as application protocol, not just transport

[Http](https://de.wikipedia.org/wiki/Hypertext_Transfer_Protocol) is a stateless protocol to transfer data via an application layer within a computer network.

- makes it easier for systems to communicate with each other

- separates concerns of client and server

### Is REST normally stateless (zustandslos)? ###

- yes, there is not http session usage
- GETs can be cached on URL 
- loser coupling between client and server

But what is stateless?

Stateless means that the server does not store any state about the client session on the server side.
The client session is stored on the client. 

The server is stateless means that every server can service any client at any time, there is no session affinity or sticky sessions. The relevant session information is stored on the client and passed to the server as needed.

Statelessness means that every HTTP request happens in complete isolation. When the client makes an HTTP request, it includes all the information necessary for the server to fulfill that request. The server never relies on information from previous requests. If that information was important, the client would have to send it again in subsequent request.

The client's application state should never be stored on the server, but passed around from the client to every place that needs it.
That is where the "ST" in REST comes from, State Transfer. You transfer the state around instead of having the server store it. This is the only way to scale to millions of concurrent users.

No "sessions" are defined. Don't login. Don't logout. Provide credentials with the request. Each request stands alone.
You still have data stores. You still have authentication and authorization. You just don't waste time establishing sessions and maintaining session state.

[Stackoverflow: How do you manage sessions in stateless rest applications?](https://stackoverflow.com/questions/3105296/if-rest-applications-are-supposed-to-be-stateless-how-do-you-manage-sessions#:~:text=Stateless%20means%20the%20state%20of,known%20from%20any%20prior%20request.)

### Is REST scalable and/or interoperable? ###

What is scalability?
[Skalierbarkeit](https://de.wikipedia.org/wiki/Skalierbarkeit) / scalability means that a system can handle growing work by adding more ressources.

[Horizontale Skalierbarkeit](https://de.wikipedia.org/wiki/Skalierbarkeit#Horizontale_Skalierung_(scale_out))

Rest is scalable and interoperable. It does not mandate a specific choice of technology on client or server side.

The server end of REST is stateless, which means that the server doesn't have to store anything across requests. This means that there doesn't have to be (much) communication between servers, making it horizontally scalable.

[Stackoverflow: Why are restful applications easier to scale?](https://stackoverflow.com/questions/11297471/why-are-restful-applications-easier-to-scale)


### What is a resource?  ###

- the constraint of statelessness is enforces through the use of resources rather than commands
- resources are the noans of the Web and describe any object/document/thing that you may need to store or send to other services

### What does CRUD mean? ###

### Is REST secure? What can you do to secure it? ###



### Which HTTP methods does REST use? ###

### What is an HttpMessageConverter? ###



### What does @RequestMapping do? ###

### Is @Controller a stereotype? Is @RestController a stereotype? ###

### What is a stereotype annotation? What does that mean? ###

### What is the difference between @Controller and @RestController? ###

### When do you need @ResponseBody? ###

### What are the HTTP status return codes for a successful GET, POST, PUT or DELETE opreation? ###

### When do you need @ResponseStatus? ###

### Where do you need @ResponseBody? What about @RequestBody? Try not to get these muddled up. ###

### If you saw example Controller code, would you understand what it is doing? Could you tell if it was annotated correctly? ###

### Do you need Spring MVC in your classpath? ###

### What Spring Boot starter would you use for a Spring REST application? ###

### What are the advantages of the RestTemplate? ###

### If you saw an example using RestTemplate would you understand what it is doing? ###
