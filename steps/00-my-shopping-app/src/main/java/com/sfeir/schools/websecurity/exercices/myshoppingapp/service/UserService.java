package com.sfeir.schools.websecurity.exercices.myshoppingapp.service;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.dto.UserDto;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.mapper.UserDtoMapper;
import com.sfeir.schools.websecurity.exercices.myshoppingapp.repository.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements UserDetailsService {
  private static final Pattern EMAIL_VALIDATION_PATTERN = Pattern.compile("^([a-zA-Z0-9])(([\\-.]|[_]+)?(([a-zA-Z0-9]+)+))*(@){1}[a-z0-9]+[.]{1}(([a-z]{2,3})|([a-z]{2,3}[.]{1}[a-z]{2,3}))$", Pattern.CASE_INSENSITIVE);
  @Resource
  private UserRepository userRepository;
  @Resource
  private UserDtoMapper userDtoMapper;

  @Override
  public User loadUserByUsername(String email) throws UsernameNotFoundException {
    final User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException(email);
    }
    return user;
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  public List<UserDto> listUsers() {
    return userRepository.findAll().stream().map(userDtoMapper::userToUserDto).collect(Collectors.toList());
  }

  public UserDto getUser(String email) {
    return userDtoMapper.userToUserDto(loadUserByUsername(email));
  }

  public Boolean validateEmailFormat(User user) {
    return EMAIL_VALIDATION_PATTERN.matcher(user.getEmail()).find();
  }

  public void delete(Long userId) {
    userRepository.deleteById(userId);
  }
}
