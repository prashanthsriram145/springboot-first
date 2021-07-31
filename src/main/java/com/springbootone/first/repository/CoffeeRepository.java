package com.springbootone.first.repository;

import com.springbootone.first.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Integer> {

}
