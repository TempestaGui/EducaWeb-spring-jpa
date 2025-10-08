package org.educandoweb.educaweb.repository;

import org.educandoweb.educaweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
