package com.aravind.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@Getter
@Setter
public class Product {

    @Id
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;

}
