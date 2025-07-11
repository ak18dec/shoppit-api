package com.shoppit.product_service.controller;

import com.shoppit.product_service.entity.Product;
import com.shoppit.product_service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void shouldReturnAllProducts() throws Exception {
        Product p1 = new Product(1L, "Laptop", "Gaming laptop", 1200.0, 10, 1L);
        Product p2 = new Product(2L, "Phone", "Smartphone", 700.0, 20, 2L);

        when(productService.getAllProducts()).thenReturn(Arrays.asList(p1, p2));

        mockMvc.perform(get("/api/products")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void shouldCreateProduct() throws Exception {
        Product p1 = new Product(1L, "Tablet", "Android tablet", 300.0, 15, 1L);

        when(productService.addProduct(any(Product.class))).thenReturn(p1);

        String json = """
            {
              "name": "Tablet",
              "description": "Android tablet",
              "price": 300.0,
              "stock": 15,
              "categoryId": 1
            }
            """;

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Tablet"));
    }
}
