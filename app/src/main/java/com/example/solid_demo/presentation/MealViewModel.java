package com.example.solid_demo.presentation;

import com.example.solid_demo.domain.models.Meal;
import com.example.solid_demo.domain.repository.IMealRepository;
import com.example.solid_demo.utils.Result;

import java.util.List;

/**
 * SOLID Principle: DIP (Dependency Inversion Principle)
 * The ViewModel is decoupled from data logic. It only knows about the IMealRepository
 * contract, making it 100% testable using mock repositories.
 */
public class MealViewModel {
    private final IMealRepository repository;

    public MealViewModel(IMealRepository repository) {
        this.repository = repository;
    }

    public void loadMeals(String category) {
        Result<List<Meal>> result = repository.getMealsByCategory(category);
        if (result.isSuccess()) {
            // Update UI State
        }
    }
}