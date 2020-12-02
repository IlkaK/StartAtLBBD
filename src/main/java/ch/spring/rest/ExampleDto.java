package main.java.ch.spring.rest;

public class ExampleDto {
	
	private String id;

    @NotEmpty(message = "Example name must be set.")
    private String name;

    // standard setters and getters

}
