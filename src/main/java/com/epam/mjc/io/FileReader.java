package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            StringBuilder profileData = new StringBuilder();
            while (reader.ready()) {
                profileData.append(reader.readLine()).append("\n");
            }
            String[] pairs = profileData.toString().split("\n");

            for (String pair : pairs) {
                String[] keyValue = pair.split(" ");
                switch (keyValue[0]) {
                    case "Name:": profile.setName(keyValue[1]);break;
                    case "Age:": profile.setAge(Integer.parseInt(keyValue[1]));break;
                    case "Email:": profile.setEmail(keyValue[1]);break;
                    case "Phone:": profile.setPhone(Long.parseLong(keyValue[1]));break;
                    default: break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }

}
