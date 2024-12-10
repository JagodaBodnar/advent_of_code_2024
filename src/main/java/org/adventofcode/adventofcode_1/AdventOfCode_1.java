package org.adventofcode.adventofcode_1;


import java.util.List;
import java.util.Objects;

public class AdventOfCode_1 {
    public static String filePath = "src/main/java/org/jsonpath/adventofcode_1/adventOfCode_1Input";
    public static List<Integer> firstList;
    public static List<Integer> secondList;

    public static void main(String[] args) {
        AdventOfCode_1 adventOfCode1 = new AdventOfCode_1();
        // Read input from file and assign to 2 lists;
        firstList = ReadFile.readListFromFile(filePath, 0);
        secondList = ReadFile.readListFromFile(filePath, 1);
        // Sort lists;
        List<Integer> sortedFirstList = adventOfCode1.sortList(firstList);
        List<Integer> sortedSecondList = adventOfCode1.sortList(secondList);

        //    --- Day 1: Historian Hysteria part1 ---
        int totalDistanceBetweenLists = adventOfCode1.compareNumbersAndSumDiff(sortedFirstList, sortedSecondList);
        System.out.println("totalDistanceBetweenLists = " + totalDistanceBetweenLists); //2192892;

        //    --- Day 1: Historian Hysteria part2 ---
        int similarityScore = adventOfCode1.findSimilarityScore();
        System.out.println("similarityScore = " + similarityScore); //22962826;
    }

    public List<Integer> sortList(List<Integer> list) {
        list.sort(Integer::compare);
        return list;
    }

    public int compareNumbersAndSumDiff(List<Integer> list1, List<Integer> list2) {
        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list2.get(i) - list1.get(i));
        }
        return sum;
    }

    public int findSimilarityScore() {
        int sum = 0;
        for (Integer integer : firstList) {
            sum += Math.abs(integer * findNumberOfRepetitions(integer));
        }
        return sum;
    }

    public int findNumberOfRepetitions(Integer number) {
        return secondList.stream().filter(el -> Objects.equals(el, number)).toList().size();
    }
}