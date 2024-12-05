import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static List<Integer>[] buildLists(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean isFirstList = true;
        while (scanner.hasNextInt()) {
            if (isFirstList) {
                list1.add(scanner.nextInt());
                isFirstList = false;
            } else {
                list2.add(scanner.nextInt());
                isFirstList = true;
            }
        }
        return new List[]{list1, list2};
    }

    public static int findDifference(List<Integer>[] lists) {
        List<Integer> list1 = lists[0];
        List<Integer> list2 = lists[1];
        int totalDifference = 0;
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        for (int i = 0; i < list1.size(); i++) {
            totalDifference += Math.abs(list1.get(i) - list2.get(i));
        }
        return totalDifference;
    }

    public static int calculateSimilarityScore(List<Integer>[] lists) {
        int similarityScore = 0;
        List<Integer> list1 = lists[0];
        List<Integer> list2 = lists[1];

        for (int value1 : list1) {
            int count = 0;
            for (int value2 : list2) {
                if (value1 == value2) {
                    count++;
                }
            }
            similarityScore += value1 * count;
        }
        return similarityScore;
    }
}
