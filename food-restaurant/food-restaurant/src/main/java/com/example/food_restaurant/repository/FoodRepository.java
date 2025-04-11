package com.example.food_restaurant.repository;

import com.example.food_restaurant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
