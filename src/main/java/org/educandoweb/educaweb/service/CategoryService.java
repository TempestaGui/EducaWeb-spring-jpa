package org.educandoweb.educaweb.service;

import org.educandoweb.educaweb.entity.Category;
import org.educandoweb.educaweb.repository.CategoryRepository;
import org.educandoweb.educaweb.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if(category == null){
            throw new IllegalArgumentException("Category not found");
        }
        return category;
    }
}
