package com.example.baitap6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baitap6.model.Category;
import com.example.baitap6.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
// public class CategoryService {
// private List<Category> listCategory = new ArrayList<>();

// public CategoryService() {
// // Initialize with some sample categories
// listCategory.add(new Category(1, "Điện thoại"));
// listCategory.add(new Category(2, "Laptop"));
// listCategory.add(new Category(3, "Máy tính bảng"));
// }

// public List<Category> getAll() {
// return listCategory;
// }

// public Category get(int id) {
// return listCategory.stream()
// .filter(c -> c.getId() == id)
// .findFirst()
// .orElse(null);
// }
// }

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
