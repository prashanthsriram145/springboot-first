package com.springbootone.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
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
