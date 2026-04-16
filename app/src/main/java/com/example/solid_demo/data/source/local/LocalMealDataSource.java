package com.example.solid_demo.data.source.local;

import com.example.solid_demo.data.dto.MealDto;
import com.example.solid_demo.data.mapper.MealMapper;
import com.example.solid_demo.data.source.IMealDataSource;
import com.example.solid_demo.domain.models.Meal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SOLID Principle: SRP (Single Responsibility Principle)
 * Consistency: Just like the Remote source, the Local source handles its own mapping.
 * The Repository receives the same Domain Model regardless of the source.
 */
public class LocalMealDataSource implements IMealDataSource {
    private final MealMapper mapper;

    public LocalMealDataSource(MealMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Meal> getMeals(String category) {
        List<MealDto> cachedData = fetchFromRoom(category);
        return cachedData.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    public void saveToCache(List<Meal> meals) { /* Logic to persist Domain meals */ }

    private List<MealDto> fetchFromRoom(String category) {
        return List.of();
    }
}
