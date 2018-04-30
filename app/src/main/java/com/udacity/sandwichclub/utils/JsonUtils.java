package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSON = new JSONObject(json);

            JSONObject name = sandwichJSON.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray aka = name.getJSONArray("alsoKnownAs");
            List<String> akaStr = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                akaStr.add(aka.get(i).toString());
            }

            String placeOfOrigin = sandwichJSON.getString("placeOfOrigin");
            String description = sandwichJSON.getString("description");
            String image = sandwichJSON.getString("image");

            JSONArray ingredients = sandwichJSON.getJSONArray("ingredients");
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
