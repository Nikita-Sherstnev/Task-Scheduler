package com.sherstnyov.taskscheduler.jpa.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "user_role",
    joinColumns = {
      @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        nullable = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name = "role_id",
        referencedColumnName = "id",
        nullable = false
      )
    }
  )
  private List<Role> roles = new ArrayList<>();

  @OneToMany(
    mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
  )
  private List<Task> tasks = new ArrayList<>();
}
