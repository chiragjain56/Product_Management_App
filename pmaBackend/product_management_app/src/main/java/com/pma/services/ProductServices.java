package com.pma.services;

import com.pma.model.Product;

import java.util.List;

public interface ProductServices {

    public Product getProductById(Integer id);

    public List<Product> getAllProduct();

    public Product saveProduct(Product product);

    public Product updateProductbyId(Product product, Integer id);

    public String deleteProductbyId(Integer id);

}
