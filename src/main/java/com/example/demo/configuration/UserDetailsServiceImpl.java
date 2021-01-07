package com.example.demo.configuration;

import com.example.demo.user.Userz;
import com.example.demo.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Userz inDB = userRepository.findByUsername(username);
    if (inDB == null) {
      throw new UsernameNotFoundException(username);
    }
    return new AppUser(inDB); 
  }
  
}
