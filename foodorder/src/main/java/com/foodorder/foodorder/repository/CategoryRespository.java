package com.foodorder.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorder.foodorder.entity.Category;

public interface  CategoryRespository extends JpaRepository<Category, Integer>{
    
}
