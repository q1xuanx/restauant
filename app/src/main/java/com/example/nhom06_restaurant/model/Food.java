package com.example.nhom06_restaurant.model;

import java.util.List;

public class Food {
    private String idPic;
    private String idFood;
    private String foodName;
    private String detailsFood;
    private int timesOrder;
    private List<Ingredients> ingredients;
    private float cost;
    private FoodTaste foodTaste;
    private FoodType foodType;
    public Food(){

    }

    public Food(String idPic, String idFood, String foodName, String detailsFood, float cost) {
        this.idPic = idPic;
        this.idFood = idFood;
        this.foodName = foodName;
        this.detailsFood = detailsFood;
        this.timesOrder = 0;
        this.cost = cost;
    }

    public Food(String idPic, String idFood, String foodName, String detailsFood, List<Ingredients> ingredients, float cost, FoodTaste foodTaste, FoodType foodType) {
        this.idPic = idPic;
        this.idFood = idFood;
        this.foodName = foodName;
        this.detailsFood = detailsFood;
        this.timesOrder = 0;
        this.ingredients = ingredients;
        this.cost = cost;
        this.foodTaste = foodTaste;
        this.foodType = foodType;
    }

    public String getDetailsFood() {
        return detailsFood;
    }

    public void setDetailsFood(String detailsFood) {
        this.detailsFood = detailsFood;
    }

    public int getTimesOrder() {
        return timesOrder;
    }

    public void setTimesOrder(int timesOrder) {
        this.timesOrder = timesOrder;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public FoodTaste getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(FoodTaste foodTaste) {
        this.foodTaste = foodTaste;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public String getIdPic() {
        return idPic;
    }

    public void setIdPic(String idPic) {
        this.idPic = idPic;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
