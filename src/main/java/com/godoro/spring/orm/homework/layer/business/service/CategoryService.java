package com.godoro.spring.orm.homework.layer.business.service;

import com.godoro.spring.orm.homework.layer.data.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createSampleCategory();

    List<Category> findAll();

    Optional<Category> findById(long categoryId);
}
