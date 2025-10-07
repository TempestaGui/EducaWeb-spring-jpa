package org.educandoweb.educaweb.repository;


import org.educandoweb.educaweb.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface OrderRepository extends JpaRepository<Order, Long> {
}
