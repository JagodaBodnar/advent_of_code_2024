package org.adventofcode.adventofcode_3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileOperations {
    public static List<List<Integer>> readListFromFile(String filePath) {
        List<List<Integer>> list = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                Pattern pattern = Pattern.compile("mul\\((\\w+,\\w+)\\)");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    List<Integer> group= Arrays.stream(matcher.group(1).split(",")).map(Integer::valueOf).toList();
                    list.add(group);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String readFile(String filePath) {
        String lines = "";
        try{
           lines = String.join("",Files.readAllLines(Paths.get(filePath)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
    public static void overrideTheFile(String path, String content){
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}