package com.godoro.spring.orm.homework.layer.business.service.impl;

import com.godoro.spring.orm.homework.layer.business.service.ProductService;
import com.godoro.spring.orm.homework.layer.data.entity.Product;
import com.godoro.spring.orm.homework.layer.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    public int countByCategory(long categoryId) {
        return (int) productRepository.countByCategory(categoryId);
    }

    @Override
    public Optional<Product> findById(long productId) {
        return productRepository.findById(productId);
    }

}
