package com.sfeir.schools.websecurity.exercices.myshoppingapp.controller;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.ShoppingListDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingList;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.service.ShoppingListService;
import jakarta.annotation.Resource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/list")
public class ShoppingListController {
  @Resource
  ShoppingListService shoppingListService;

  @PostMapping
  public ShoppingList createList(@AuthenticationPrincipal User user, @RequestBody ShoppingListDto shoppingList) {
    return shoppingListService.createList(user, shoppingList.getName());
  }

  @GetMapping
  public List<ShoppingList> getMyLists(@AuthenticationPrincipal User user) {
    return shoppingListService.getMyLists(user.getId());
  }

  @PutMapping("/{listId}")
  public ShoppingList renameList(@PathVariable Long listId, @RequestBody ShoppingListDto shoppingList) {
    return shoppingListService.renameList(listId, shoppingList.getName());
  }

  @GetMapping("/delete/{listId}")
  public void deleteList(@AuthenticationPrincipal User user, @PathVariable Long listId) {
    shoppingListService.deleteList(user.getId(), listId);
  }
}
