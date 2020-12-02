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

Infos zur [Horizontalen Skalierbarkeit](https://de.wikipedia.org/wiki/Skalierbarkeit#Horizontale_Skalierung_(scale_out))

What is interoperability?

[Interoperabilität](https://de.wikipedia.org/wiki/Interoperabilit%C3%A4t) / interoperability means different systems can work with each other smoothly.

Rest is scalable and interoperable. It does not mandate a specific choice of technology on client or server side.

The server end of REST is stateless, which means that the server doesn't have to store anything across requests. This means that there doesn't have to be (much) communication between servers, making it horizontally scalable.

[Stackoverflow: Why are restful applications easier to scale?](https://stackoverflow.com/questions/11297471/why-are-restful-applications-easier-to-scale)


### What is a resource?  ###

- the constraint of statelessness is enforces through the use of resources rather than commands
- resources are the noans of the Web and describe any object/document/thing that you may need to store or send to other services


-------


### What does CRUD mean? ###

- Create, Read (or Retrieve), Update, Delete (or Destroy)

Es geht um das Anlegen, Lesen, Verändern und Löschen von Datensätzen, also um die Grundlagen um Daten zu verwenden und zu verändern.

Bei HTML/Rest findet sich CRUD unter folgenden Operationen wieder:

- Create	 -> PUT oder POST
- Read -> GET
- Update -> PATCH oder PUT
- Delete -> DELETE

[Crud auf Wikipedia](https://de.wikipedia.org/wiki/CRUD)


### Is REST secure? What can you do to secure it? ###

Since REST is stateless, each request needs to be authenticated and authorized. It cannot depend on cookies or sessions. "Instead, each API request should come with some sort authentication credentials which must be validated on the server for every request."

[Rest Tutorial](https://restfulapi.net/security-essentials/#:~:text=Security%20isn't%20an%20afterthought.&text=There%20are%20multiple%20ways%20to,depend%20on%20cookies%20or%20sessions.)


Spring Security can can be set up in a Web Environment. Three steps are necessary:

1. Setup Filter Chain (Spring Boot does that) => slx framework übernimmt das für uns

2. Configure security (authorization) rules => Berechtigungsobjekte werden festgelegt und auf den Java Methoden/Klassen gesetzt, die via REST aufgerufen werden. Sobald bekannt ist, welcher Benutzer sich eingeloggt hat, kann ermittelt werden, ob er die entsprechenden Berechtigungsobjekte hat, um eine Methode/Klasse aufzurufen.

3. Setup Web Authentication => Zertifikate werden ausgetauscht, anhand dessen bestimmt wird, ob ein Benutzer (mit diesem Zertifikat) generell bekannt ist und Zugriff hat oder nicht.


[Security => What are authentication and authorization?](./06_Security.md)


### Which HTTP methods does REST use? ###

REST can use any HTTP method. Most popular ones are:
- GET for retrieving a source
- POST for creating a resource
- PUT for updating
- DELETE for removing


-------

### What is an HttpMessageConverter? ###

It converts http requests/responses body data (object into text conversion).

Message converters marshall and unmarshall Java Objects to and from JSON, XML, etc – over HTTP.

When the server receives a request from the client, Spring uses the Accept header send by the client to define the media type of the response.

```
curl --header "Accept: application/json" 
  http://localhost:8080/spring-boot-rest/foos/1
 ```

Quick example from [Baeldung](https://www.baeldung.com/spring-httpmessageconverter-rest):

- The Client sends a GET request to /foos with the Accept header set to *application/json*. He wants to get all Foo resources as JSON.
- The Foo Spring Controller is hit and returns the corresponding Foo Java entities
- Spring then uses one of the Jackson (e.g. MappingJacksonHttpMessageConverter) message converters to marshall the entities to JSON

For that the response data needs the annotation @ResponseBody.
The conversion is automatically set up by SpringBoot.


### What does @RequestMapping do? ###

The @RequestMapping annotation can be applied to class-level and/or method-level in a controller. 
The class-level annotation maps a specific request path or pattern onto a controller. 

[Eine der ersten Annotationen auf dem ExampleRestControllers](../../src/main/java/ch/spring/rest/ExampleRestController.java)

It also maps web /http requests to Spring Controller methods. It allows the same URL to be mapped to multiple Java methods.

E.g. both of the following methods map to the same URL "/ex/foos" but the first one only response to GET requests the second one only to POST requests.

```
@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
public String getFoosBySimplePath() {
    return "Get some Foos";
}
```

```
@RequestMapping(value = "/ex/foos", method = RequestMethod.POST)
public String postFoos() {
    return "Post some Foos";
}
```

Statt ``RequestMapping(method = ...)`` verwenden wir die spezifischeren Annotation ``@GetMapping``, ``@PostMapping``, ``@PutMapping``, ``@DeleteMapping``.
Das sind Ableitungen vom @RequestMapping, wobei jeweils ``method`` hard-codiert ist.

[Nähere Infos dazu sind hier](https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/request-mapping-variants.html)

[Auf den Methoden des ExampleRestControllers](../../src/main/java/ch/spring/rest/ExampleRestController.java)

Die Definition von consumes und produces sollte im @RequestMapping eigentlich nicht (mehr) notwendig sein (siehe der Kommentar von [Hynes auf der Diskussion im Stackoverflow](https://stackoverflow.com/questions/35123835/spring-requestmapping-for-controllers-that-produce-and-consume-json) Diese wird vom Accept Header des Client Requests vorgegeben.

[Auf der @RequestMapping Annotation des ExampleRestControllers](../../src/main/java/ch/spring/rest/ExampleRestController.java)

### When do you need @ResponseBody? ###

You need the annotation when you define a Rest response and your service is not annotated with @RestController.

### Where do you need @ResponseBody? What about @RequestBody? Try not to get these muddled up. ###

- @RequestBody: method parameter is bound to the body of the http request
- @ResponseBody: can be put on a method, it indicates the return type should be written straight to http response body.

[Am Anfang vom ExampleRestController](../../src/main/java/ch/spring/rest/ExampleRestController.java)

-------

### Is @Controller a stereotype? Is @RestController a stereotype? ###

Both are stereotype annotations.

@RestController combines @Controller and @ResponseBody, so no need to annotate every request handling method of the controller class with @ResponseBody annotation. 

### What is a stereotype annotation? What does that mean? ###

Simplifying object creation, Spring automatically creates a Bean from a stereotype.
If the correct stereotype is used on a bean, then Spring is directed in the right direction and knows what kind of bean it has.

E.g. a controller's role in MVC pattern is to direct traffic and route requests (@Controller) or a repository is a place to implement data access layers for various persistence stores. The example is taken from [here](https://www.danvega.dev/blog/2017/03/27/spring-stereotype-annotations/).

### What is the difference between @Controller and @RestController? ###

The @RestController annotation in Spring MVC is a combination of @Controller and @ResponseBody annotation.

The job of @Controller is to create a Map of the model object and find a view but @RestController simply returns the object and object data is directly written into HTTP response as JSON or XML.

This can also be done with traditional @Controller and use @ResponseBody annotation but since this is the default behavior of RESTful Web services, Spring introduced @RestController which combined the behavior of @Controller and @ResponseBody together.

[Information from here](https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html#ixzz6ee6SW1WC)

-------

### What are the HTTP status return codes for a successful GET, POST, PUT or DELETE operation? ###

- 201: created successfully
- 400: client error
- 405: http method not supported
- 406: cannot generate response body in requested format
- 415: request body not supported

### When do you need @ResponseStatus? ###

When you want to specify other http status. For that you put @ResponseStatus on void methods.

### When do you need @ResponseEntity? ###

ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
ResponseEntity is a generic type.
[Information from Bealdung](https://www.baeldung.com/spring-response-entity)

``return ResponseEntity.ok("All good.")`` Returns with a HTTP 200 response code and a body "All good"

-------

### Do you need Spring MVC in your classpath? ###

If you use Spring Boot, then yes.

### What Spring Boot starter would you use for a Spring REST application? ###

Spring-boot-starter-web is used for a standard Spring Rest application.

### What are the advantages of the RestTemplate? ###

- It provides accesss to Restful services.
- It supports all the HTTP methods.

