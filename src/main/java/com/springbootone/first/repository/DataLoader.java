package com.springbootone.first.repository;

import com.springbootone.first.model.Coffee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    private CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    public void loadData() {
        coffeeRepository.save(new Coffee(1, "Choco"));
        coffeeRepository.save(new Coffee(2, "Latte"));
        coffeeRepository.save(new Coffee(3, "Espresso"));
    }
}
