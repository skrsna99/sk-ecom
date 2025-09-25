package com.ecommerce.project.controller;

import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct( @RequestBody ProductDTO productDTO,
                                                 @PathVariable Long categoryId){
        ProductDTO ProductDTO = productService.addProduct(categoryId, productDTO);
        return new ResponseEntity<>(ProductDTO, HttpStatus.CREATED);
    }
}
