package com.godoro.spring.orm.homework.layer.data.repository;

import com.godoro.spring.orm.homework.layer.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryId(long categoryId);

    Optional<Category> findByCategoryName(String name);
}
