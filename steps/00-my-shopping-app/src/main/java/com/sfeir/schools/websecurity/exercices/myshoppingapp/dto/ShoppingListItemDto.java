package com.sfeir.schools.websecurity.exercices.myshoppingapp.dto;

import lombok.Data;

@Data
public class ShoppingListItemDto {
  private Long id;
  private Long listId;
  private String name;
  private Boolean isChecked;
  private String logoImageId;
}
