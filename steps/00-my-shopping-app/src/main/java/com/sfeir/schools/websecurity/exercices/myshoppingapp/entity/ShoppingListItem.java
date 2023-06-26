package com.sfeir.schools.websecurity.exercices.myshoppingapp.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListItem {
  public interface WithoutListView {};
  public interface WithListView extends WithoutListView {};

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @JsonView(WithoutListView.class)
  private Long id;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonView(WithListView.class)
  private ShoppingList shoppingList;

  @Column(length=64, nullable=false)
  @JsonView(WithoutListView.class)
  private String name;

  @Column(nullable=false)
  @JsonView(WithoutListView.class)
  private Boolean isChecked;

  @PrePersist
  public void prePersist() {
    if(isChecked == null)
      isChecked = false;
    if (logoImageId == null)
      logoImageId = "photo1.jpg";
  }

  @Column(length=128)
  private String logoImageId;
}
