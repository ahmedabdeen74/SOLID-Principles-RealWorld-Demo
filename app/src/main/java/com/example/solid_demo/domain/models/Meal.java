package com.example.solid_demo.domain.models;

/**
 * SOLID Principle: SRP (Single Responsibility Principle)
 * This class is a "Domain Entity". Its only responsibility is to represent
 * the business model of a Meal. It is decoupled from any API or Database logic.
 */
public class Meal {
    private final String id;
    private final String title;
    private final String imageUrl;

    public Meal(String id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
}
