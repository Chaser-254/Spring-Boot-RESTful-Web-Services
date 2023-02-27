package com.example.springbootapplication.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        product almond = new Product();
        honey.setId("2");
        honey.setName("Almond");
        productRepo.put(honey.getId(), almond);
    }

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.pu(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    @RequestMapping(value="/product/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") string id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is successfully", HttpStatus.OK);
    }
    @RequestMapping(value="/products/{id}", method=RequstMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
