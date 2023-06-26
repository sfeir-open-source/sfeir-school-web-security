package com.sfeir.schools.websecurity.exercices.myshoppingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingList {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JsonIgnore
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;

  @Column(length=64, nullable=false)
  private String name;
}
