package com.xworkz.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.food.dto.FoodDTO;
import com.xworkz.food.service.FoodService;

@Controller
@RequestMapping("/")
public class FoodController {

	@Autowired
	private FoodService foodService;

	public FoodController() {
		System.out.println("running FoodController");
	}

	@RequestMapping("/food")
	public String onClick(FoodDTO foodDTO) {
		System.out.println("running onClick method");
		System.out.println(foodDTO);
		boolean valid = foodService.isValid(foodDTO);
		return "Food.jsp";
	}
}
