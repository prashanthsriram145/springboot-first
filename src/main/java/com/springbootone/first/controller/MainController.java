package com.springbootone.first.controller;

import com.springbootone.first.model.Coffee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffee")
public class MainController {

    List<Coffee> coffees = new ArrayList<>();

    public MainController() {
        coffees.add(new Coffee(1, "Choco"));
        coffees.add(new Coffee(2, "Latte"));
        coffees.add(new Coffee(3, "Espresso"));
    }

    @GetMapping
    public ResponseEntity<List<Coffee>> getCoffees() {
        return ResponseEntity.ok(coffees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable int id) {
        for(Coffee coffee : coffees) {
            if (coffee.getId() == id) {
                return ResponseEntity.ok(coffee);
            }
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return ResponseEntity.ok(coffee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        int index = -1;
        for (Coffee c : coffees) {
            if (c.getId() == id) {
                index = coffees.indexOf(coffee);
                coffees.set(index, coffee);
            }
        }
        if (index == -1) {
            return ResponseEntity.ok(addCoffee(coffee).getBody());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable int id) {
        coffees.removeIf(coffee -> coffee.getId() == id);
    }

}
