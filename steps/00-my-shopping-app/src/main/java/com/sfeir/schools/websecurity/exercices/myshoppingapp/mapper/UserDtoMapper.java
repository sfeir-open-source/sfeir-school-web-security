package com.sfeir.schools.websecurity.exercices.myshoppingapp.mapper;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.UserDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.Role;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import org.mapstruct.Mapper;

@Mapper
public abstract class UserDtoMapper {
  public abstract UserDto userToUserDto(User user);

  public String roleToString(Role role) {
    return role.getName();
  }
}
