package com.sherstnyov.taskscheduler.security;

import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class UserDetails extends User {
  private final Long id;

  public UserDetails(
    Long id,
    String username,
    String password,
    Collection<? extends GrantedAuthority> authorities
  ) {
    super(username, password, authorities);
    this.id = id;
  }
}
