package com.pma.controller;

import com.pma.model.Product;
import com.pma.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProductHandler(@RequestBody Product product) {
        return new ResponseEntity<>(productServices.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProductHandler() {
        return new ResponseEntity<>(productServices.getAllProduct(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByIdHandler(@PathVariable Integer id) {
        return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProductByIdHandler(@PathVariable Integer id) {
        productServices.deleteProductbyId(id);
        return new ResponseEntity<>("Product is Deleted", HttpStatus.OK);
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<?> editProductHandler(@RequestBody Product product, @PathVariable Integer id) {
        return new ResponseEntity<>(productServices.updateProductbyId(product, id), HttpStatus.OK);
    }
}
