package com.xworkz.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.food.dto.FoodDTO;
import com.xworkz.food.entity.FoodEntity;
import com.xworkz.food.repository.FoodRepository;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public boolean isValid(FoodDTO foodDTO) {
		FoodEntity foodEntity = new FoodEntity();
		foodEntity.setName(foodDTO.getName());
		foodEntity.setCost(foodDTO.getCost());
		boolean saved = foodRepository.save(foodEntity);
		return false;
	}

}
