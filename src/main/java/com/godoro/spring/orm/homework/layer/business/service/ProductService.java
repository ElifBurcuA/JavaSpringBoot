package com.godoro.spring.orm.homework.layer.business.service;

import com.godoro.spring.orm.homework.layer.data.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void delete(long productId);

    List<Product> findAll();

    int countByCategory(long categoryId);


    Optional<Product> findById(long productId);
}
