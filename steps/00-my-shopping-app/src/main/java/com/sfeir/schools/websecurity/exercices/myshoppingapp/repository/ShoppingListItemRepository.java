package com.sfeir.schools.websecurity.exercices.myshoppingapp.repository;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {
  List<ShoppingListItem> findAllByShoppingListId(Long shoppingListId);
}
