package com.godoro.spring.orm.homework.layer.presentation.rest;

import com.godoro.spring.orm.homework.layer.business.service.CategoryService;
import com.godoro.spring.orm.homework.layer.business.service.ProductService;
import com.godoro.spring.orm.homework.layer.data.entity.Category;
import com.godoro.spring.orm.homework.layer.data.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<Product>> findProductByCategoryId(@PathVariable("categoryId") long categoryId) {
        return ResponseEntity.ok(categoryService
                .findById(categoryId)
                .map(Category::getProductList).orElse(null));

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") long productId) {
        return ResponseEntity.ok(productService
                .findById(productId).orElse(null));

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }


}
