package com.example.solid_demo.data.mapper;

import com.example.solid_demo.data.dto.MealDto;
import com.example.solid_demo.domain.models.Meal;

/**
 * SOLID Principle: SRP (Single Responsibility Principle)
 * A dedicated class for mapping logic. It ensures that the Repository
 * doesn't get cluttered with transformation logic between Data and Domain layers.
 */
public class MealMapper {
    public Meal toDomain(MealDto dto) {
        return new Meal(dto.idMeal, dto.strMeal, dto.strMealThumb);
    }
}
