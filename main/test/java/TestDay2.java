import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class TestDay2 {

    @Test
    public void findSafeReports_path_int() throws IOException {
        final var actualResult = Day2.findSafeReports(Path.of("resources\\day2TestInput.txt"));
        assertEquals(2, actualResult);
    }

    @Test
    public void findSafeReportsWithDampener_path_int() throws IOException {
        final var actualResult = Day2.findSafeReportsWithDampener(Path.of("resources\\day2TestInput.txt"));
        assertEquals(4, actualResult);
    }
}
