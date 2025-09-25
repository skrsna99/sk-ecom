package com.ecommerce.project.service;

import com.ecommerce.project.payload.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO product);
}
