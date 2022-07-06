package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class GsonExample1 {

        public static void main(String[] args) {

            // pretty print

            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
                    .create();



            ArrayList<Staff> staffs = createStaffObject();

            // Java objects to String
            String json = gson.toJson(staffs);
            try (FileWriter writer = new FileWriter("student.json")) {
                gson.toJson(staffs, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static ArrayList<Staff> createStaffObject() {

            Staff staff = new Staff();
            Staff staffNew = new Staff();
            ArrayList<Staff> arrayList = new ArrayList<>();

            staff.setName("oleg");
            staff.setAge(35);
            staff.setPosition(new String[]{"Founder", "SEO", "coder"});
            Map<String, BigDecimal> salary = new HashMap() {{
                put("2010", new BigDecimal(10000));
                put("2012", new BigDecimal(12000));
                put("2018", new BigDecimal(14000));
            }};
            staff.setSalary(salary);
            staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

//            Задание: Добавьте еще одного сотрудника и прочтите данные из файла.

            staffNew.setName("Ivan");
            staffNew.setAge(24);
            staffNew.setPosition(new String[]{"Coder", "Founder", "SEO"});
            salary = new HashMap() {{
                put("2020", new BigDecimal(13000));
                put("2021", new BigDecimal(14000));
                put("2022", new BigDecimal(15000));
            }};
            staffNew.setSalary(salary);
            staffNew.setSkills(Arrays.asList("js", "php", "C++", "C#"));

            arrayList.add(staff);
            arrayList.add(staffNew);


            return arrayList;
        }
    }


