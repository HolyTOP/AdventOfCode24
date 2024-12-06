import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //File file = new File("main\\test\\resources");
        //for(String fileNames : file.list()) System.out.println(fileNames);
        List<Integer>[] lists = Day1.buildLists(new File("main\\src\\resources\\day1_input.txt"));
        System.out.println("Day 1 first answer: " + Day1.findDifference(lists));
        System.out.println("Day 1 second answer: " + Day1.calculateSimilarityScore(lists));

        int safeReportCount = Day2.findSafeReports(Path.of("main\\src\\resources\\day2_input.txt"));
        System.out.println("\nDay 2 first answer: " + safeReportCount);
        int safeDampenedReportCount = Day2.findSafeReportsWithDampener(Path.of("main\\src\\resources\\day2_input.txt"));
        System.out.println("\nDay 2 second answer: " + safeDampenedReportCount);
    }
}
