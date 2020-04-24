package com.sherstnyov.taskscheduler.jpa.domain;

import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

@Entity
@Data
@Table(name = "tasks")
public class Task {
  @Id
  @Column(name = "id_task")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String description;

  @Nullable
  private Instant deadline;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_user", nullable = false)
  private User user;
}
