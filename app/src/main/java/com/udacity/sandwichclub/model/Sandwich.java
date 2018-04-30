package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public Sandwich setMainName(String mainName) {
        this.mainName = mainName;
        return this;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public Sandwich setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
        return this;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public Sandwich setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sandwich setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Sandwich setImage(String image) {
        this.image = image;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Sandwich setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
