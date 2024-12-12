package com.xworkz.food.repository;

import org.springframework.stereotype.Repository;

import com.xworkz.food.entity.FoodEntity;

@Repository
public interface FoodRepository {

	boolean save(FoodEntity foodEntity);
}
