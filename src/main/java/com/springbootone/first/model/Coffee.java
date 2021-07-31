package com.springbootone.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private int id;
    private String name;

    @Override
    public boolean equals(Object coffee) {
        return this.getId() == ((Coffee)coffee).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
