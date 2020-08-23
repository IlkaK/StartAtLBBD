# Spring MVC and the Web Layer #

### MVC is an abbreviaton for design pattern. What does it stand for and what is the idea behind it? ###

MVC = Model-View-Controller pattern

The big idea behind it: each section of code has a purpose and those purposes are different
1. code holding the date of the application
2. code for GUI
3. code that controls how the application works

### What is the DispatcherServlet and what is it used for? ###

The DispatcherServlet acts as a FrontController.
It receives all incoming requests and delegates to other components for further processing to 
1. Spring MVC Controllers (@Controller) or
2. ViewResolvers like InternalResourceViewResolver

### What is a web application context? What extra scopes does it offer? ###

WebApplicationContext is an interface to provide configuration for web applications. It is extending ApplicationContext and has a contract for accessing ServletContext.

- scope_application: scope identifier for the global web application scope "application"
- scope_request: scope identifier for request scope "request" => every Http request will have his own instance of a bean
- scope_session: scope for the lifecycle of a HTTP session


### What is the @Controller annotation used for? ###

@Controller handles Http requests.

### How is an incoming request mapped to a controller and mapped to a method? ###

@Controller with @GetMapping and @RequestBody on a method <=> @RestController with @GetMapping on method

### What is the difference between @RequestMapping and @GetMapping? ###

@GetMapping = shortcut for @RequestMapping  (method = RequestMapping.GET)
- GetMapping -> applied on method level
- RequestMapping -> applied on class or method level

### What is @RequestParam used for? ###

It extracts parameter from the request, e.g. 

`@GetMapping("/account")`

`public List<Account>list (@RequestParam("userid") int userid) { ... }`

is used for: http://localhost:8080/account?userid=1234

### What are the differences between @RequestParam and @PathVariable? ####

@PathVariable refers to {...} in URL 

@GetMapping("/accounts/{userId}") <=> @PathVariable long userId

http://localhost:8080/accounts/1234?overdrawn=true
- 1234 is the value of the @PathVariable
- overdrawn=true is the @RequestParam boolean overdrawn

### What are some of the parameter types for a controller method? ####

- request and response objects
- session object of type HttpSession
- java.io.InputStream|Reader -> access to request's content
- java.io.OutputStream|Writer -> generating the respnonse's content

### What other annotations might you use for a controller method parameter? (You can ignore form-handling annotations for this exam) ####

@RequestHeader, @RequestPart

### What are some of the valid return types of a controller method? ####

- Model and View object, Model object, Map, View, String void