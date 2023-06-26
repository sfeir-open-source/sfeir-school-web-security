package com.sfeir.schools.websecurity.exercices.myshoppingapp.repository;

import com.sfeir.schools.websecurity.exercices.myshoppingapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
