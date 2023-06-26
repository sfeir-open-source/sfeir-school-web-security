package com.sfeir.schools.websecurity.exercices.myshoppingapp.service;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.ShoppingListItemDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingListItem;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.mapper.ShoppingListItemDtoMapper;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListItemRepository;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ShoppingListItemService {
  @Resource
  ShoppingListItemRepository shoppingListItemRepository;
  @Resource
  ShoppingListRepository shoppingListRepository;
  @Resource
  ShoppingListItemDtoMapper shoppingListItemDtoMapper;

  public ShoppingListItem addItem(Long listId, String name) {
    var list = shoppingListRepository.findById(listId).orElseThrow();
    return shoppingListItemRepository.save(ShoppingListItem.builder().name(name).shoppingList(list).isChecked(false).build());
  }

  public ShoppingListItem getById(Long itemId) {
    return shoppingListItemRepository.findById(itemId).orElseThrow();
  }

  public List<ShoppingListItem> getByList(Long listId) {
    return shoppingListItemRepository.findAllByShoppingListId(listId);
  }

  public ShoppingListItem update(Long itemId, ShoppingListItemDto shoppingListItemDto) {
    var listItem = shoppingListItemRepository.findById(itemId).orElseThrow();
    shoppingListItemDtoMapper.updateItemFromDto(shoppingListItemDto, listItem);
    return shoppingListItemRepository.save(listItem);
  }

  public void setLogo(Long itemId, String logoId) {
    var listItem = shoppingListItemRepository.findById(itemId).orElseThrow();
    listItem.setLogoImageId(logoId);
    shoppingListItemRepository.save(listItem);
  }

  public void deleteItem(Long itemId) {
    shoppingListItemRepository.deleteById(itemId);
  }
}
