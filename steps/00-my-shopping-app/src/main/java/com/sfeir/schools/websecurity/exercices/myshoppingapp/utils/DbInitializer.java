package com.sfeir.schools.websecurity.exercices.myshoppingapp.utils;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.Role;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingList;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.ShoppingListItem;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.RoleRepository;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListItemRepository;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.ShoppingListRepository;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DbInitializer {

  @Resource
  UserRepository userRepository;
  @Resource
  RoleRepository roleRepository;
  @Resource
  ShoppingListRepository shoppingListRepository;
  @Resource
  ShoppingListItemRepository shoppingListItemRepository;

  @EventListener(ApplicationReadyEvent.class)
  public void initDb() {
    var adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
    var userRole = roleRepository.save(Role.builder().name("USER").build());
    var someAdmin = userRepository.save(User.builder().name("The Admin").email("admin@example.com")
        .password(passwordEncoder().encode("123456"))
        .roles(Collections.singletonList(adminRole)).build());
    var someUser = userRepository.save(User.builder().name("The User").email("user@example.com")
        .password(passwordEncoder().encode("123456"))
        .roles(Collections.singletonList(userRole)).build());
    var adminList1 = shoppingListRepository.save(ShoppingList.builder().name("My admin shopping list").user(someAdmin).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Potatoes").shoppingList(adminList1).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("French fries").shoppingList(adminList1).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Vegetables").shoppingList(adminList1).build());
    var adminList2 = shoppingListRepository.save(ShoppingList.builder().name("My passwords").user(someAdmin).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Gmail: sje83je3zsk358").shoppingList(adminList2).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Slack: 9XLGç9d'çD").shoppingList(adminList2).build());
    var userList1 = shoppingListRepository.save(ShoppingList.builder().name("Some user list").user(someUser).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Chocolate").shoppingList(userList1).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Candies").shoppingList(userList1).build());
    var userList2 = shoppingListRepository.save(ShoppingList.builder().name("Some other user list").user(someUser).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Salmon").shoppingList(userList2).build());
    shoppingListItemRepository.save(ShoppingListItem.builder().name("Butter").shoppingList(userList2).build());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(4);
  }
}
