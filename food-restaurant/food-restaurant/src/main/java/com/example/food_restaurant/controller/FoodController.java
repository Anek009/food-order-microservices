package com.example.food_restaurant.controller;

import com.example.food_restaurant.model.Food;
import com.example.food_restaurant.repository.FoodRepository;
import com.example.food_restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    public final FoodRepository foodRepository;
    public final FoodService foodService;

    public FoodController(FoodRepository foodRepository, FoodService foodService) {
        this.foodRepository = foodRepository;
        this.foodService = foodService;
    }

    @PostMapping
    public Food createFood(@RequestBody Food food) {

        return foodService.createFood(food);
    }
    @PostMapping("/bulk")
    public ResponseEntity<List<Food>> getFoodByIds(@RequestBody List<Long> ids) {
        List<Food> foodList = ids.stream()
                .map(id -> foodService.getFoodById(id)
                        .map(food -> food)
                        .orElseThrow(() -> new RuntimeException("No food available for id {"+id+"}")))
                .toList();
        return ResponseEntity.ok(foodList);
    }
    @GetMapping("/id")
    public ResponseEntity<Optional<Food>> getFoodById(@PathVariable Long id)
    {
        Optional<Food> hfood=foodService.getFoodById(id);
        return ResponseEntity.ok().body(hfood);
    }
}
