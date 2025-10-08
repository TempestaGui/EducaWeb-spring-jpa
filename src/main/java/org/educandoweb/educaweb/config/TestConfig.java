package org.educandoweb.educaweb.config;

import org.educandoweb.educaweb.entity.Category;
import org.educandoweb.educaweb.entity.Order;
import org.educandoweb.educaweb.entity.User;
import org.educandoweb.educaweb.enums.OrderStatusEnum;
import org.educandoweb.educaweb.repository.CategoryRepository;
import org.educandoweb.educaweb.repository.OrderRepository;
import org.educandoweb.educaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //quando spring estiver rodando, vai resolver essa dependencias e associa um userRepository aqui
    private UserRepository ur;

    @Autowired
    private OrderRepository or;

    @Autowired
    private CategoryRepository cr;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, u1 ,Instant.parse("2019-06-20T19:53:07Z"), OrderStatusEnum.PAID);
        Order o2 = new Order(null, u2 ,Instant.parse("2019-07-21T03:42:10Z"),OrderStatusEnum.WAITING_PAYMENT);
        Order o3 = new Order(null, u1 ,Instant.parse("2019-07-22T15:21:22Z"),OrderStatusEnum.WAITING_PAYMENT);


        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        ur.saveAll(Arrays.asList(u1, u2));
        or.saveAll(Arrays.asList(o1,o2,o3));
        cr.saveAll(Arrays.asList(c1,c2,c3));
    }
}
