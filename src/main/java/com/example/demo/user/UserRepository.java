package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userz, Long> {

  Userz findByUsername(String username);
  
}
