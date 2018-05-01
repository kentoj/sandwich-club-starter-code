package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static String
            SANDWICH_NAME = "name",
            SANDWICH_MAIN_NAME = "mainName",
            SANDWICH_ALSO_KNOWN_AS = "alsoKnownAs",
            SANDWICH_PLACE_OF_ORIGIN = "placeOfOrigin",
            SANDWICH_DESCRIPTION = "description",
            SANDWICH_IMAGE = "image",
            SANDWICH_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSON = new JSONObject(json);

            JSONObject name = sandwichJSON.getJSONObject(SANDWICH_NAME);
            String mainName = name.optString(SANDWICH_MAIN_NAME);
            JSONArray aka = name.getJSONArray(SANDWICH_ALSO_KNOWN_AS);
            List<String> akaStr = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                akaStr.add(aka.get(i).toString());
            }

            String placeOfOrigin = sandwichJSON.getString(SANDWICH_PLACE_OF_ORIGIN);
            String description = sandwichJSON.getString(SANDWICH_DESCRIPTION);
            String image = sandwichJSON.getString(SANDWICH_IMAGE);

            JSONArray ingredients = sandwichJSON.getJSONArray(SANDWICH_INGREDIENTS);
            List<String> ingredientsStr = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsStr.add(ingredients.get(i).toString());
            }
            return new Sandwich()
                    .setMainName(mainName)
                    .setAlsoKnownAs(akaStr)
                    .setDescription(description)
                    .setImage(image)
                    .setIngredients(ingredientsStr)
                    .setPlaceOfOrigin(placeOfOrigin);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
