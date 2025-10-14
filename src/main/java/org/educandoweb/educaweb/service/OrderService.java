package org.educandoweb.educaweb.service;

import org.educandoweb.educaweb.entity.Order;
import org.educandoweb.educaweb.repository.OrderRepository;
import org.educandoweb.educaweb.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if(order == null){
            throw new IllegalArgumentException("Order not found");
        }
        return order;
    }
}
