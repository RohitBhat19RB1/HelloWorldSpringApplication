package com.example.demo.Controller;

import com.example.demo.Model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRESTController {

	// curl localhost:8080/hello -w "\n"
	@RequestMapping(value = { "", "/", "/home" })
	public String sayHello() {
		return "Hello World!";
	}

	// curl localhost:8080/hello/query?name=Pratik -w "\n"
	// curl -X GET "http://localhost:8080/hello/query/?fName=Rohit&lName=Bhat" -w "\n"
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName) {
		return "Hello " + fName + " " + lName + " !";
	}

	// curl -X GET "http://localhost:8080/hello/param/Rohit" -w "\n"
	@GetMapping("/param/{name}" )
	public String sayHelloParam(@PathVariable String name) {
			return "Hello "  + name + "!";
	}

	// curl -X POST -H "Content-Type: application/json" -d 
	// '{"firstName": "Lisa", "lastName": "Harry"}'
	// "http://localhost:8080/hello/post" -w "\n"
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
			return "Hello " + user.getFirstName() + " " + user.getLastName() + '!';
	}

	// curl -X PUT localhost:8080/hello/put/Lisa/?lastName=Terrisa -w "\n"
	@PutMapping("/put/{firstName}")
	public String sayHelloo(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
			return "Hello " + firstName + " " + lastName + '!';
	}
}
