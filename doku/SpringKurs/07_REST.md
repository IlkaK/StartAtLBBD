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
- POST for craeting a resource
- PUT for updating
- DELETE for removing


-------

### What is an HttpMessageConverter? ###

It converts http requests/responses body data (object into text conversion).

Message converters marshall and unmarshall Java Objects to and from JSON, XML, etc – over HTTP.
The client server conversation uses Json. When receiving a request (from the client), Spring uses the Accept header to define the media type of the response.

Quick example from [Baeldung](https://www.baeldung.com/spring-httpmessageconverter-rest):

- The Client sends a GET request to /foos with the Accept header set to application/json. He wants to get all Foo resources as JSON.
- The Foo Spring Controller is hit and returns the corresponding Foo Java entities
- Spring then uses one of the Jackson (e.g. MappingJacksonHttpMessageConverter) message converters to marshall the entities to JSON

For that the response data needs the annotation @ResponseBody.
The conversion is automatically set up by SpringBoot.

### What does @RequestMapping do? ###

It maps web /http requests to Spring Controller methods. It allows the same URL to be mapped to multiple Java methods.

E.g. both of the following methods map to the same URL "/ex/foos" but the first one only response to GET requests the second one only to POST requests.

```
@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
@ResponseBody
public String getFoosBySimplePath() {
    return "Get some Foos";
}
```

```
@RequestMapping(value = "/ex/foos", method = POST)
@ResponseBody
public String postFoos() {
    return "Post some Foos";
}
```

### Is @Controller a stereotype? Is @RestController a stereotype? ###

Both are stereotype annotations.

@RestController combines @Controller and @ResponseBody, so no need to annotate every request handling method of the controller class with @ResponseBody annotation. 

### What is a stereotype annotation? What does that mean? ###

Simplifying object creation, Spring automatically creates a Bean from a stereotype.
If the correct stereotype is used on a bean, then Spring is directed in the right direction and knows what kind of bean it has.

E.g. a controller's role in MVC pattern is to direct traffic and route requests (@Controller) or a repository is a place to implement data access layers for various persistence stores. The example is taken from [here](https://www.danvega.dev/blog/2017/03/27/spring-stereotype-annotations/).

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
