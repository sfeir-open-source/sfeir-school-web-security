package com.sfeir.schools.websecurity.exercices.myshoppingapp.service;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingList;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {
  @Resource
  ShoppingListRepository shoppingListRepository;

  public ShoppingList createList(User user, String listName) {
    return shoppingListRepository.save(ShoppingList.builder().name(listName).user(user).build());
  }

  public ShoppingList renameList(Long listId, String newName) {
    var list = shoppingListRepository.findById(listId).get();
    list.setName(newName);
    return shoppingListRepository.save(list);
  }

  public List<ShoppingList> getMyLists(Long userId) {
    return shoppingListRepository.findAllByUserId(userId);
  }

  public void deleteList(Long userId, Long listId) {
    shoppingListRepository.deleteById(listId);
  }
}
