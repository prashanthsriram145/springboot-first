package com.springbootone.first.controller;

import com.springbootone.first.common.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    @Value("${name: Sriram}")
    private String name;

    @Value("${coffeeMsg: Someone is drinking some coffee}")
    private String coffeeMsg;

    private Greeting greeting;

    public GreetingsController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public ResponseEntity<String> greeting() {
//        return ResponseEntity.ok("Hello " + name);
        return ResponseEntity.ok("Hello " + greeting.getName());
    }

    @GetMapping("/coffee")
    public ResponseEntity<String> getCoffeeGreeeting() {
//        return ResponseEntity.ok(coffeeMsg);
        return ResponseEntity.ok(greeting.getCoffeeMsg());
    }
}
