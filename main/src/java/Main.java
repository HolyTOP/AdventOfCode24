import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);
        List<Integer>[] lists = Day1.buildLists(new File("main\\src\\resources\\day1_input.txt"));
        System.out.println("Day 1 first answer: " + Day1.findDifference(lists));
        System.out.println("Day 1 second answer: " + Day1.calculateSimilarityScore(lists));
    }
}
