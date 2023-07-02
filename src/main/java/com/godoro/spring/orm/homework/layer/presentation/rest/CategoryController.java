package com.godoro.spring.orm.homework.layer.presentation.rest;

import com.godoro.spring.orm.homework.layer.business.service.CategoryService;
import com.godoro.spring.orm.homework.layer.data.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }


    @GetMapping("/create-sample")
    public ResponseEntity<Category> createCategory() {
        return ResponseEntity.ok(categoryService.createSampleCategory());
    }


}
