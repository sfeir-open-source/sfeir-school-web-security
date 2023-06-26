package com.sfeir.schools.websecurity.exercices.myshoppingapp.repository;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
  void deleteById(Long id);
}
