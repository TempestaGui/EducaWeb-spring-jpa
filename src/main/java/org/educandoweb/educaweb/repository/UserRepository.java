package org.educandoweb.educaweb.repository;

import org.educandoweb.educaweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
