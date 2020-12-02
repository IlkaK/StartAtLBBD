package main.java.ch.spring.rest;


@Validated // ueberprueft die Validierungsannotationen aus den verwendeten Klassen/Dtos (hier ExampleDto)
@RestController // Die Annotation kombiniert Controller und ResponseBody. Damit hat jede Methode automatisch die Annotation ResponseBody.
@RequestMapping( 
	produces = MediaType.APPLICATION_JSON_VALUE, // sollte eigentlich nicht (mehr) noetig sein, da durch den Accept Header des Client Requests gesetzt
	path = "/contract/example")
public class ExampleRestController {
	
	@GetMapping
	@ResponseBody // Die Annotation ist hier ueberfluessig, da sie bereits im @RestController auf der Klasse enthalten ist.
	              // Wenn wir aber in einem @Controller waeren, muessten wir sie auf Methodenlevel hinzufuegen.
	              // Sie beschreibt, dass der Rueckgabewert (hier ein Set von examples) direkt als HTTP Response geschrieben wird.
	              // Welche Art von HTTP Response der Client benoetigt, kommt normalerweise im "Accept" Header des Clients.
	              // Mit dieser Information wird in den registrierten HttpMessageConvertern nach einem dazu passenden gesucht.
	              // z.B. MappingJacksonHttpMessageConverter
	public ResponseEntity<Set<ExampleDto>> getAllExamples() {
		Set<ExampleDto> examples = exampleService.getAll();
		return ResponseEntity.ok(examples); // in the HTTP header ok code is sent, in the body, the set of examples are sent
	}
	
	@GetMapping
	public ResponseEntity<ExampleDto> getExample(@PathVariable @NotNull String id) {
		return ResponseEntity.ok(exampleService.find(id));
	}
	
	@PostMapping
	public ResponseEntity<String> createExample(@Valid @RequestBody ExampleDto exampleDto) {
		ExampleDto createdExampleDto = exampleService.create(exampleDto);
		return ResponseEntity.ok(createdExampleDto.getId().toString());
	}
	
	@PutMapping
	public ResponseEntity<Void> updateExample(@Valid @RequestBody ExampleDto exampleDto) {
		exampleService.update(exampleDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteOrder(@PathVariable @NotNull String id){
		exampleService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK); // returns only ok status code, no body, no header
	}
	
}
