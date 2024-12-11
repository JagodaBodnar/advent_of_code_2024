package org.adventofcode.adventofcode_3;


import java.util.List;

public class AdventOfCode_3 {
    private static final String filePath = "src/main/java/org/adventofcode/adventofcode_3/adventOfCode_3Input";
    public static void main(String[] args) {
       var listFromFile = ReadFile.readListFromFile(filePath);
        System.out.println("Sum of multiplications; = " + sum(listFromFile));
    }
    private static long sum(List<List<Integer>> listFromFile){
        long sum = 0;
        for(var list: listFromFile){
            sum += multiply(list.get(0), list.get(1));
        }
        return sum;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }
}
