package com.godoro.spring.orm.homework.layer.business.service.impl;

import com.godoro.spring.orm.homework.layer.business.service.CategoryService;
import com.godoro.spring.orm.homework.layer.data.entity.Category;
import com.godoro.spring.orm.homework.layer.data.entity.Product;
import com.godoro.spring.orm.homework.layer.data.repository.CategoryRepository;
import com.godoro.spring.orm.homework.layer.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category createSampleCategory() {
        String sampleCategoryName = "Ev - Dekorasyon";
        Category category = new Category();
        category.setCategoryName(sampleCategoryName);
        categoryRepository.save(category);

        createSampleProducts(category);

        return categoryRepository.findByCategoryName(sampleCategoryName).orElse(null);
    }

    public void createSampleProducts(Category category) {
        Product product1 = new Product();
        product1.setProductName("Yatak");
        product1.setSalesPrice(3900);
        product1.setCategory(category);
        product1.setImageUrl("https://stn-yatsan.mncdn.com/mnresize/1500/1500/Content/media/ProductImg/original/mmm-045487-king-koil-penrose-yatak-637698863096928359.jpg");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductName("Dolap");
        product2.setSalesPrice(3900);
        product2.setCategory(category);
        product2.setImageUrl("https://koctas-img.mncdn.com/mnresize/600/600/productimages/1000700340/1000700340_1_MC/8851478937650_1674221473484.jpg");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductName("Ayna");
        product3.setSalesPrice(3900);
        product3.setCategory(category);
        product3.setImageUrl("https://koctas-img.mncdn.com/mnresize/600/600/productimages/9100023350/9100023350_1_MC/8828861055026_1617349460843.jpg");
        productRepository.save(product3);

    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long categoryId) {
        return categoryRepository.findById(categoryId);
    }


}
