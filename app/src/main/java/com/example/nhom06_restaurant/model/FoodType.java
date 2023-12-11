package com.example.nhom06_restaurant.model;

public class FoodType {
    private String typeOfFood;
    private String nameFoodType;

    public FoodType(){

    }

    public FoodType(String typeOfFood, String nameFoodType) {
        this.typeOfFood = typeOfFood;
        this.nameFoodType = nameFoodType;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getNameFoodType() {
        return nameFoodType;
    }

    public void setNameFoodType(String nameFoodType) {
        this.nameFoodType = nameFoodType;
    }
}
