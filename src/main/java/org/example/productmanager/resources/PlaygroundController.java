package org.example.productmanager.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playground")
//  http://localhost:8080/playground
public class PlaygroundController {

// http://localhost:8080/playground Text "G-Unit"
    @GetMapping
    public String normalGET () {
        return "G-Unit";
    }

//  GET http://localhost:8080/playground/hello-world
    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello Java Spring Boot";
    }
}
