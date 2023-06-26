package com.sfeir.schools.websecurity.exercices.myshoppingapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.ShoppingListItemDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingListItem;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.service.ShoppingListItemService;
import jakarta.annotation.Resource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/listitem")
public class ShoppingListItemController {
  private ResourceLoader resourceLoader = new DefaultResourceLoader();
  private static final List<String> VALID_LOGOS =  Arrays.asList("photo1.jpg", "photo2.jpg", "photo3.jpg");

  @Resource
  ShoppingListItemService shoppingListItemService;

  @PostMapping()
  public ShoppingListItem addItem(@RequestBody ShoppingListItemDto shoppingListItemDto) {
    return shoppingListItemService.addItem(shoppingListItemDto.getListId(), shoppingListItemDto.getName());
  }

  @GetMapping("/get-by-list/{listId}")
  @JsonView(ShoppingListItem.WithoutListView.class)
  public List<ShoppingListItem> getByList(@PathVariable Long listId) {
    return shoppingListItemService.getByList(listId);
  }

  @PutMapping("/{itemId}")
  public ShoppingListItem update(@PathVariable Long itemId, @RequestBody ShoppingListItemDto shoppingListItemDto) {
    return shoppingListItemService.update(itemId, shoppingListItemDto);
  }

  @GetMapping("/{itemId}/delete")
  public void delete(@PathVariable Long itemId) {
    shoppingListItemService.deleteItem(itemId);
  }

  @GetMapping(path = "/logo", produces = MediaType.IMAGE_JPEG_VALUE)
  public org.springframework.core.io.Resource getLogo(@RequestParam("itemId") Long itemId) {
    String logoId = shoppingListItemService.getById(itemId).getLogoImageId();
    return resourceLoader.getResource("logo/" + logoId);
  }

  @PostMapping("/logo")
  public void setUserLogo(@RequestBody ShoppingListItemDto shoppingList) {
    String logoId = shoppingList.getLogoImageId();
    if (!VALID_LOGOS.contains(logoId)) {
      throw new RuntimeException("Invalid logo ID");
    }
    shoppingListItemService.setLogo(shoppingList.getId(), logoId);
  }
}
