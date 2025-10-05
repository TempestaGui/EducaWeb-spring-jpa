package org.educandoweb.educaweb.config;

import org.educandoweb.educaweb.entity.User;
import org.educandoweb.educaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //quando spring estiver rodando, vai resolver essa dependencias e associa um userRepository aqui
    private UserRepository ur;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        ur.saveAll(Arrays.asList(u1, u2));
    }
}
