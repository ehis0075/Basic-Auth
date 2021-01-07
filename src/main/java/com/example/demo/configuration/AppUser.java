package com.example.demo.configuration;

import java.util.Collection;

import com.example.demo.user.Userz;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class AppUser implements UserDetails {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  Userz userz;

  public AppUser(Userz userz){
    this.userz = userz;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return AuthorityUtils.createAuthorityList("ROLE_"+this.userz.getRole());
  }

  @Override
  public String getPassword() {
    return this.userz.getPassword();
  }

  @Override
  public String getUsername() {
    return this.userz.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  
}
