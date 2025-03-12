package com.SwagLabs.Utilites.DataDriven;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JsonFile {


    private static final String JSON_FILE_PATH = "src/test/resources/";

    public static String getJsonData(String fileName, String jsonPath) {
        String filePath = JSON_FILE_PATH + fileName + ".json";

        try {
            // Read and parse JSON file
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
            String jsonReader = jsonObject.toJSONString();

            // Extract data using JSONPath
            return JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            System.err.println("Error reading JSON file '" + fileName + "' or parsing JSON path '" + jsonPath + "': " + e.getMessage());
        }

        return null;
    }



/// ####################################################################################################### ///











//    private static final String JSON_FILE_PATH = "src/test/resources/";
//    private static final Map<String, String> jsonFilesData = new HashMap<>();
//
//    public static void loadJsonFile(String fileName) {
//        if (jsonFilesData.containsKey(fileName)) {
//            return;
//        }
//
//        try {
//            String filePath = JSON_FILE_PATH + fileName + ".json";
//            System.out.println("Loading JSON file: " + filePath); // Debugging print
//            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(filePath));
//            jsonFilesData.put(fileName, data.toJSONString());
//            System.out.println("JSON Loaded Successfully: " + fileName);
//        } catch (Exception e) {
//            System.err.println("Error loading JSON file '" + fileName + "': " + e.getMessage());
//        }
//    }
//
//
//    public static String getJsonData(String fileName, String jsonPath) {
//        if (!jsonFilesData.containsKey(fileName)) {
//            loadJsonFile(fileName);
//        }
//
//        String jsonReader = jsonFilesData.get(fileName);
//        if (jsonReader == null || jsonReader.isEmpty()) {
//            System.err.println("JSON data is null or empty for file: " + fileName);
//            return null;
//        }
//
//        String testData = "";
//        try {
//            testData = JsonPath.read(jsonReader, jsonPath);
//        } catch (Exception e) {
//            System.err.println("No results for json path: " + jsonPath + " in the json file " + fileName);
//        }
//        return testData;
//    }




//    public static String getJsonData(String jsonFilename, String parentField, String childField) {
//        try {
//            FileReader reader = new FileReader(JSON_FILE_PATH + jsonFilename + ".json");
//            JsonElement jsonElement = JsonParser.parseReader(reader);
//            JsonObject jsonObject = jsonElement.getAsJsonObject();
//
//            // Check if the parent key exists
//            if (jsonObject.has(parentField) && jsonObject.get(parentField).isJsonObject()) {
//                JsonObject parentObject = jsonObject.getAsJsonObject(parentField);
//
//                // Check if the child key exists
//                if (parentObject.has(childField) && !parentObject.get(childField).isJsonNull()) {
//                    return parentObject.get(childField).getAsString();
//                } else {
//                    System.err.println("Child key does not exist or contains null: " + childField);
//                }
//            } else {
//                System.err.println("Parent key does not exist or is not a JSON object: " + parentField);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

}

