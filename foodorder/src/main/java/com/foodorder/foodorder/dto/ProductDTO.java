package com.foodorder.foodorder.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;

    public ProductDTO(Long id, String name, int categoryId, double price, double weight, String description, String imageName) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.imageName = imageName;
    }
}
