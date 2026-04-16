package com.example.solid_demo.data.source.remote;


import com.example.solid_demo.data.dto.MealDto;
import com.example.solid_demo.data.mapper.MealMapper;
import com.example.solid_demo.data.source.IMealDataSource;
import com.example.solid_demo.domain.models.Meal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SOLID Principle: SRP (Single Responsibility Principle)
 * This class handles remote API calls AND performs the mapping to Domain entities.
 * By returning List<Meal>, it hides all "DTO" details from the Repository.
 */
public class RemoteMealDataSource implements IMealDataSource {
    private final MealMapper mapper;

    public RemoteMealDataSource(MealMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Meal> getMeals(String category) {
        // Mocking an API response
        List<MealDto> apiResponse = fetchFromRetrofit(category);

        // Mapping logic encapsulated within the source
        return apiResponse.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    private List<MealDto> fetchFromRetrofit(String category) {
        return List.of(new MealDto());
    }
}
