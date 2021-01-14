package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRESTController {

	// curl localhost:8080/hello -w "\n"
	@RequestMapping(value = { "", "/", "/home","/roit" })
	public String sayHello() {
		return "Hello World!";
	}

	// curl localhost:8080/hello/query?name=Pratik -w "\n"
	// curl -X GET "http://localhost:8080/hello/query/?fName=Pratik&lName=Valvi" -w "\n"
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName) {
		return "Hello " + fName + " " + lName + " !";
	}

	// curl -X GET "http://localhost:8080/hello/param/Pratik" -w "\n"
	@GetMapping("/param/{name}" )
	public String sayHelloParam(@PathVariable String name) {
			return "Hello "  + name + "!";
	}
	
}
