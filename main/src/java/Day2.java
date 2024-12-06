import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static int findSafeReports(Path path) throws IOException {
        int safeCount = 0;
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            List<Integer> numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            boolean isIncreasing = numbers.get(1) > numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                if ((Math.abs(numbers.get(i) - numbers.get(i - 1)) > 3) ||
                        (numbers.get(i).equals(numbers.get(i - 1))) ||
                        (isIncreasing && (!(numbers.get(i) > numbers.get(i - 1)))) ||
                        (!isIncreasing && (numbers.get(i) > numbers.get(i - 1)))) {
                    break;
                } else if (i == numbers.size() - 1) {
                    safeCount++;
                }
            }
        }
        return safeCount;
    }

    public static int findSafeReportsWithDampener(Path path) throws IOException {
        int safeCount = 0;
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            List<Integer> numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            boolean isFirstStrike = true;
            boolean isIncreasing = numbers.get(1) > numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {

                // Are there same numbers?
                if (numbers.get(i).equals(numbers.get(i - 1))) {
                    if (!isFirstStrike) {
                        break;
                    } else {
                        isFirstStrike = false;
                        numbers.remove(i);
                        i--;
                    }
                }

                // Increasing
                if (isIncreasing) {
                    if (numbers.get(i) < numbers.get(i - 1)) {
                        //TODO
                    }
                }

            }
        }
        return safeCount;
    }
}























/**
 * if (numbers.get(i).equals(numbers.get(i - 1))) {
 *                     if (isFirstStrike) {
 *                         numbers.remove(i);
 *                         isFirstStrike = false;
 *                         i--;
 *                     } else {
 *                         break;
 *                     }
 *                 }
 *
 *                 if (Math.abs(numbers.get(i) - numbers.get(i - 1)) > 3) {
 *                     if (isIncreasing) {
 *                         if (Math.abs(numbers.get(i + 1) - numbers.get(i - 1)) > 3) {
 *                             numbers.remove(i - 1);
 *                         }
 *                     }
 *
 *                     //TODO
 *                 }
 *
 *                 if (isIncreasing && (!(numbers.get(i) > numbers.get(i - 1)))) {
 *                     if (isFirstStrike) {
 *                         if (i > 1 && numbers.get(i) > numbers.get(i - 2)) {
 *                             numbers.remove(i - 1);
 *                         } else {
 *                             numbers.remove(i);
 *                         }
 *                         isFirstStrike = false;
 *                         i--;
 *                     } else {
 *                         break;
 *                 } else if (!isIncreasing && (numbers.get(i) > numbers.get(i - 1))) {
 *                     if (isFirstStrike) {
 *                         isFirstStrike = false;
 *                         i--;
 *                         if (numbers.get(i) > numbers.get(i - 2)) {
 *                             numbers.remove(i - 1);
 *                         } else {
 *                             numbers.remove(i);
 *                         }
 *                     }
 *                 }
 *
 *
 *
 *                     // Dampener
 *                     if (isFirstStrike) {
 *                         isFirstStrike = false;
 *                         numbers.remove(i - 1);
 *                         i--;
 *                     } else {
 *                         break;
 *                     }
 *                 } else if (i == numbers.size() - 1) {
 *                     safeCount++;
 *                 }
 */