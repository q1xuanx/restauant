package com.example.nhom06_restaurant.model;

public class FoodTaste {
    private String idTaste;
    private String nameTaste;

    public FoodTaste(){

    }
    public FoodTaste(String idTaste, String nameTaste) {
        this.idTaste = idTaste;
        this.nameTaste = nameTaste;
    }

    public String getIdTaste() {
        return idTaste;
    }

    public void setIdTaste(String idTaste) {
        this.idTaste = idTaste;
    }

    public String getNameTaste() {
        return nameTaste;
    }

    public void setNameTaste(String nameTaste) {
        this.nameTaste = nameTaste;
    }
}
