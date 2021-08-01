package com.springbootone.first.controller;

import com.springbootone.first.common.Droid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/droid")
public class DroidController {

    private final Droid droid;

    public DroidController(Droid droid) {
        this.droid = droid;
    }

    @GetMapping("/hello")
    public ResponseEntity<Droid> getDroid() {
        return ResponseEntity.ok(droid);
    }
}
