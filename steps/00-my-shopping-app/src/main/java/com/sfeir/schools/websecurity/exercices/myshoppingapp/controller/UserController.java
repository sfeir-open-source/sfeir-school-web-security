package com.sfeir.schools.websecurity.exercices.myshoppingapp.controller;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.UserDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(maxAge = 3600)
@Slf4j
public class UserController {

  @Resource
  UserService userService;
  @GetMapping("/my-data")
  public UserDto getMyData(@AuthenticationPrincipal User user) {
    return userService.getUser(user.getEmail());
  }

  @GetMapping
  public List<UserDto> listUsers(@AuthenticationPrincipal User user) {
    try {
      return userService.listUsers();
    } catch (Exception e) {
      log.warn("User [" + user + "] got access denied");
      throw e;
    }
  }

  @GetMapping("/check-email-format")
  public String validateEmailFormat(@AuthenticationPrincipal User user) {
    if (userService.validateEmailFormat(user)) {
      return "Email has a valid format !";
    } else {
      return "Email might not be valid, you will maybe not receive our email notifications.";
    }
  }

  @PostMapping("/delete")
  public void delete(@AuthenticationPrincipal User user, HttpServletRequest request) {
    userService.delete(user.getId());
    SecurityContextHolder.clearContext();
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
  }
}
