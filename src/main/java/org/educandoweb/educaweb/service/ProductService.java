package org.educandoweb.educaweb.service;

import org.educandoweb.educaweb.entity.Product;
import org.educandoweb.educaweb.repository.ProductRepository;
import org.educandoweb.educaweb.service.exception.ResourceNotFoundException;
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
        Product product  = productRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException(Id));
        if(product == null){
            throw new IllegalArgumentException("Product not found");
        }
        return product;
    }
}
