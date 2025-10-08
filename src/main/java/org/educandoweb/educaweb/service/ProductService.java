package org.educandoweb.educaweb.service;

import org.educandoweb.educaweb.entity.Product;
import org.educandoweb.educaweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long Id){
        return productRepository.findById(Id).orElse(null);
    }
}
