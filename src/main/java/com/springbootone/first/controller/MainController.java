package com.springbootone.first.controller;

import com.springbootone.first.model.Coffee;
import com.springbootone.first.repository.CoffeeRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
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

    private CoffeeRepository coffeeRepository;


    public MainController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Coffee>> getCoffees() {
        List<Coffee> coffeeList = getCoffeesList();
        return ResponseEntity.ok(coffeeList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffee(@PathVariable int id) {
        for(Coffee coffee : getCoffeesList()) {
            if (coffee.getId() == id) {
                return ResponseEntity.ok(coffee);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
        coffeeRepository.save(coffee);
        return ResponseEntity.ok(coffee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        boolean exists = coffeeRepository.existsById(id);
        ResponseEntity<Coffee> responseEntity = null;
        if (exists) {
            responseEntity = new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable int id) {
        coffeeRepository.deleteById(id);
    }

    private List<Coffee> getCoffeesList() {
        List<Coffee> coffeeList = new ArrayList<>();
        coffeeRepository.findAll().forEach(coffee -> coffeeList.add(coffee));
        return coffeeList;
    }

}
