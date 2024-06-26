package com.cathal.flappy.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static String loadAsString(String filepath) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String buffer = "";
            while ((buffer = reader.readLine()) != null) {
                result.append(buffer + '\n');
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Could not find file " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("No more to read in file " + filepath);
        }
        return result.toString();
    }

    private FileUtils(){}

}
