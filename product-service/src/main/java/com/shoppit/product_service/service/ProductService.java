package com.shoppit.product_service.service;

import com.shoppit.product_service.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);

}
