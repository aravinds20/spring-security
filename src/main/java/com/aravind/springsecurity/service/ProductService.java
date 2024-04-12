package com.aravind.springsecurity.service;

import com.aravind.springsecurity.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    static List<Product > productList;

    static {

        productList = IntStream.range(1,100).mapToObj(i->Product.builder()
                .id(i)
                .name("product_"+i)
                .quantity(new Random().nextInt(10))
                .price(new Random().nextInt(1000)).build())
                .collect(Collectors.toList());
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(Integer id) {
        return productList.stream().filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(()->new RuntimeException("product "+id+" not found"));
    }



}
