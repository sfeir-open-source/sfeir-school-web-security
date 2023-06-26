package com.sfeir.schools.websecurity.exercices.myshoppingapp.repository;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
  List<ShoppingList> findAllByUserId(Long userId);
}
