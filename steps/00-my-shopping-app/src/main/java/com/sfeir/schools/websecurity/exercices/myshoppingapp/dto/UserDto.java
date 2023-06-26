package com.sfeir.schools.websecurity.exercices.myshoppingapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
  private Long id;
  private String name;
  private String email;
  private List<String> roles;
}
