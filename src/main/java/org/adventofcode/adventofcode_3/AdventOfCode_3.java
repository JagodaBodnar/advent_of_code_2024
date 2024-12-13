package org.adventofcode.adventofcode_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventOfCode_3 {
    private static final String filePathInput = "src/main/java/org/adventofcode/adventofcode_3/adventOfCode_3Input";
    private static final String filePathOutput = "src/main/java/org/adventofcode/adventofcode_3/adventOfCode_3Output";

    public static void main(String[] args) {
        overrideWithStringWithRemovedDont();
        List<List<Integer>> listFromFile = FileOperations.readListFromFile(filePathOutput);
        System.out.println("Sum of multiplications; = " + sum(listFromFile));
    }

    private static long sum(List<List<Integer>> listFromFile) {
        long sum = 0;
        for (var list : listFromFile) {
            sum += multiply(list.get(0), list.get(1));
        }
        return sum;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    public static void overrideWithStringWithRemovedDont() {
        String lines = FileOperations.readFile(filePathInput);
        List<String> linesSplit = new ArrayList<>(Arrays.stream(lines.split("do")).toList());
        for (var i = 0; i < linesSplit.size();) {
            if (linesSplit.get(i).matches("^n't.*")) {
                linesSplit.remove(linesSplit.get(i));
                i--;
            }
            i++;
        }
        String linesSplitToString = String.join("", linesSplit);
        FileOperations.overrideTheFile(filePathOutput, linesSplitToString);
    }
}
