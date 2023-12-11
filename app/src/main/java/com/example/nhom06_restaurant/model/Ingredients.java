package com.example.nhom06_restaurant.model;

public class Ingredients {
    private String idIngredients;
    private String nameIngredients;

    public Ingredients(){

    }
    public Ingredients(String idIngredients, String nameIngredients) {
        this.idIngredients = idIngredients;
        this.nameIngredients = nameIngredients;
    }

    public String getIdIngredients() {
        return idIngredients;
    }

    public void setIdIngredients(String idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getNameIngredients() {
        return nameIngredients;
    }

    public void setNameIngredients(String nameIngredients) {
        this.nameIngredients = nameIngredients;
    }
}
