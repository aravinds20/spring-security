package com.aravind.springsecurity.controller;

import com.aravind.springsecurity.entity.Product;
import com.aravind.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok(new String("Hello world!"));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Product>> fetchAll(){
        return ResponseEntity.ok(productService.getProductList());
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

}
