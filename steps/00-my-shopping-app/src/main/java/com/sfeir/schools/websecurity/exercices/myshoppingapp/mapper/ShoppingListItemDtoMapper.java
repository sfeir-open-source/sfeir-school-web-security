package com.sfeir.schools.websecurity.exercices.myshoppingapp.mapper;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.ShoppingListItemDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingList;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingListItem;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListRepository;
import jakarta.annotation.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Objects;

@Mapper
public abstract class ShoppingListItemDtoMapper {
  @Resource
  ShoppingListRepository shoppingListRepository;

  @Mapping(target = "shoppingList", source = "listId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", source = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public abstract void updateItemFromDto(ShoppingListItemDto dto, @MappingTarget ShoppingListItem shoppingListItem);

  public ShoppingList shoppingListIdToShoppingList(Long shoppingListId) {
    if(Objects.isNull(shoppingListId)) {
      return null;
    }
    return shoppingListRepository.findById(shoppingListId).orElseThrow();
  }
}
