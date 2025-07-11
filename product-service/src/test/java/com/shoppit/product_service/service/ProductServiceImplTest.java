package com.shoppit.product_service.service;

import com.shoppit.product_service.entity.Product;
import com.shoppit.product_service.repository.ProductRepository;
import com.shoppit.product_service.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllProducts() {
        Product p1 = new Product(1L, "Laptop", "Gaming laptop", 1200.0, 10, 1L);
        Product p2 = new Product(2L, "Phone", "Smartphone", 700.0, 20, 2L);
        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> products = productService.getAllProducts();

        assertThat(products).hasSize(2);
        verify(productRepository, times(1)).findAll();

    }

    @Test
    void shouldReturnProductById() {
        Product p = new Product(1L, "Laptop", "Gaming laptop", 1200.0, 10, 1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(p));

        Optional<Product> result = productService.getProductById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Laptop");
    }

    @Test
    void shouldCreateProduct() {
        Product p = new Product(null, "Tablet", "Android tablet", 300.0, 15, 1L);
        Product saved = new Product(3L, "Tablet", "Android tablet", 300.0, 15, 3L);
        when(productRepository.save(p)).thenReturn(saved);

        Product result = productService.addProduct(p);

        assertThat(result.getId()).isEqualTo(3L);
        verify(productRepository).save(p);
    }

    @Test
    void shouldUpdateProduct() {
        Product existing = new Product(1L, "Laptop", "Gaming laptop", 1200.0, 10, 1L);
        Product update = new Product(1L, "Laptop Pro", "High-end gaming laptop", 1500.0, 8, 1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(productRepository.save(any(Product.class))).thenReturn(update);

        Product result = productService.updateProduct(1L, update);

        assertThat(result.getName()).isEqualTo("Laptop Pro");
        assertThat(result.getPrice()).isEqualTo(1500.0);
    }

    @Test
    void shouldDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
