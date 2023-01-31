package com.pma.services;

import com.pma.model.Product;
import com.pma.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProductbyId(Product product, Integer id) {
        Product oldProduct = productRepo.findById(id).get();
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStatus(product.getStatus());
        return productRepo.save(oldProduct);

    }

    @Override
    public String deleteProductbyId(Integer id) {
        Product product = productRepo.findById(id).get();
        if (product != null) productRepo.delete(product);
        return "Something wrong on server";
    }
}
