package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public class GsonExample2 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
//                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
                .create();



        try (Reader reader = new FileReader("student.json")) {


        Type token = new TypeToken<List<Staff>>(){}.getType();
        System.out.println(token);
        List<Staff> tokenPrint = (List<Staff>) new Gson().fromJson(reader, token);
        System.out.print(tokenPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

