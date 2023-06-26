package com.sfeir.schools.websecurity.exercices.myshoppingapp.controller;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/home")
public class HomeController {

  @GetMapping
  public String getHome(@AuthenticationPrincipal User user) {
    return "Hello " + user.getName() + " !";
  }
  @PostMapping
  public String getHome2(@AuthenticationPrincipal User user) {
    return getHome(user);
  }

  @GetMapping("/checkAccount")
  public ResponseEntity<Object> getHome(@AuthenticationPrincipal User user, @RequestParam("page") String page) {
    HttpHeaders httpHeaders = new HttpHeaders();
    page = page.startsWith("/") ? page : "/home";
    String location = user.isCredentialsNonExpired() ? page : "/resetCredentials";
    httpHeaders.setLocation(URI.create(location));
    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
  }
}
