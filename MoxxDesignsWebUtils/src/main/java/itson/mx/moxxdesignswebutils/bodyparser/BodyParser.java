/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebutils.bodyparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import serializers.CalendarDeserializer;

/**
 *
 * @author olive
 */
public class BodyParser {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Calendar.class, new CalendarDeserializer()).create();

    public static <T> T parseRequestBody(HttpServletRequest req, HttpServletResponse res, Class<T> clazz) throws IOException {
        StringBuilder jsonBody = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }
        }

        try {
            return gson.fromJson(jsonBody.toString(), clazz);
        } catch (JsonSyntaxException e) {
            throw e ;
        }
    }
}
