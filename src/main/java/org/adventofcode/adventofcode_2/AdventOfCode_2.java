package org.adventofcode.adventofcode_2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AdventOfCode_2 {
    public static String filePath = "src/main/java/org/adventofcode/adventofcode_2/adventOfCode_2Input";

    public static void main(String[] args) {
        int totalSaveReports = readFromFile(filePath);
        System.out.println("totalSaveReports = " + totalSaveReports);
    }

    public static boolean checkIfDiffGreaterThan3(List<Integer> list) {
        boolean isDiffExceded = false;
        for (var i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i + 1) - list.get(i)) > 3) {
                isDiffExceded = true;
                break;
            }
        }
        return !isDiffExceded;
    }

    public static boolean isDecreasing(List<Integer> listOfNumbers) {
        boolean isDecreasing = true;
        for (var i = 0; i < listOfNumbers.size() - 1; i++) {
            if (listOfNumbers.get(i) <= listOfNumbers.get(i + 1)) {
                isDecreasing = false;
                break;
            }
        }
        return isDecreasing;
    }

    public static boolean isIncreasing(List<Integer> listOfNumbers) {
        boolean isIncreasing = true;
        for (var i = 0; i < listOfNumbers.size() - 1; i++) {
            if (listOfNumbers.get(i) >= listOfNumbers.get(i + 1)) {
                isIncreasing = false;
                break;
            }
        }
        return isIncreasing;
    }

    public static int readFromFile(String filePath) {
        int safeReports = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (var line : lines) {
                List<Integer> lineAsList = Arrays.stream(line.split(" ")).map(Integer::valueOf).toList();
                if ((isIncreasing(lineAsList) || isDecreasing(lineAsList)) && checkIfDiffGreaterThan3(lineAsList)) {
                    safeReports++;
                } else{
                    //part two check for additional safe reports
                    safeReports += checkIfRemovingOneLevelCreatesSafeReport(lineAsList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return safeReports;
    }
    public static int checkIfRemovingOneLevelCreatesSafeReport(List<Integer> lineAsList){
        var safeReports = 0;
        for(var j = 0; j < lineAsList.size(); j++){
            var value = lineAsList.get(j);
            List<Integer> reducedList = new ArrayList<>(lineAsList);
            reducedList.remove(j);
            if ((isIncreasing(reducedList) || isDecreasing(reducedList)) && checkIfDiffGreaterThan3(reducedList)) {
                safeReports++;
                break;
            }
            reducedList.add(j, value);
        }
        return safeReports;
    }
}
