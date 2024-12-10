package org.adventofcode.adventofcode_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
    public static List<Integer> readListFromFile(String filePath, int listNumber) {
        List<Integer> list = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] split = line.split("   ");
                list.add(Integer.parseInt(split[listNumber]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}