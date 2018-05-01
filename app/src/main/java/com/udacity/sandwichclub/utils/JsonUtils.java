package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
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

            String placeOfOrigin = sandwichJSON.optString(SANDWICH_PLACE_OF_ORIGIN);
            String description = sandwichJSON.optString(SANDWICH_DESCRIPTION);
            String image = sandwichJSON.optString(SANDWICH_IMAGE);

            JSONArray ingredients = sandwichJSON.getJSONArray(SANDWICH_INGREDIENTS);
            
            return new Sandwich()
                    .setMainName(mainName)
                    .setAlsoKnownAs(toStringList(aka))
                    .setDescription(description)
                    .setImage(image)
                    .setIngredients(toStringList(ingredients))
                    .setPlaceOfOrigin(placeOfOrigin);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> toStringList(JSONArray array) {
        List<String> stringList = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                stringList.add(array.get(i).toString());
            }
        } catch (JSONException e) {
            return stringList;
        }
        return stringList;
    }
}
