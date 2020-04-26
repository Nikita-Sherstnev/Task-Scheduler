package com.sherstnyov.taskscheduler.security;

import com.sherstnyov.taskscheduler.jpa.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsService
  implements org.springframework.security.core.userdetails.UserDetailsService {
  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(
    String email
  )
    throws UsernameNotFoundException {
    return userRepository
      .findUserByEmail(email)
      .map(
        user -> {
          Long id = user.getId();
          List<GrantedAuthority> grantedAuthorities = user
            .getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
          return new UserDetails(
            id,
            email,
            user.getPassword(),
            grantedAuthorities
          );
        }
      )
      .orElseThrow(() -> new UsernameNotFoundException(email));
  }
}
