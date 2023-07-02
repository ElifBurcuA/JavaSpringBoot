package com.godoro.spring.orm.homework.layer.data.repository;

import com.godoro.spring.orm.homework.layer.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.category.categoryId = :categoryId")
    public List<Product> findByCategory(@Param("categoryId") long categoryId);

    @Query("select count (p.productId) from Product p where p.category.categoryId = :categoryId")
    public long countByCategory(long categoryId);


}
