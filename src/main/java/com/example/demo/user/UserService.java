package com.example.demo.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  UserRepository userRepository;

  PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Userz save(Userz userz){
    userz.setPassword(this.passwordEncoder.encode(userz.getPassword()));
    return this.userRepository.save(userz);
  }

}
