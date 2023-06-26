package com.sfeir.schools.websecurity.exercices.myshoppingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(length=64, nullable=false)
  private String name;

  @Column(length=128, nullable=false)
  private String email;

  @Column(length=128, nullable=false)
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
  @JoinTable(
    name="user_roles",
    joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
  private List<Role> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles;
  }

  @Override
  public String getUsername() {
    return email;
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

  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
