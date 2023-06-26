package com.sfeir.schools.websecurity.exercices.myshoppingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, unique=true)
  private String name;

  @ManyToMany(mappedBy="roles", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  private List<User> users;

  public String getAuthority() {
    return this.name;
  }
}
