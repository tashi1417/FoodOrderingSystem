package com.foodorder.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorder.foodorder.entity.Role;

public interface RoleRespository extends JpaRepository<Role, Integer> {
    
}
