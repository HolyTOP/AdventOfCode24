import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestDay1 {

    @Test
    public void buildLists_file_lists() throws FileNotFoundException {
        final var actualLists = Day1.buildLists(new File("main\\test\\resource\\day1TestInput.txt"));
        final var expectedLists = new List[]{Arrays.asList(3,4,2,1,3,3), Arrays.asList(4,3,5,3,9,3)};
        assertThat(actualLists, is(expectedLists));
    }

    @Test
    public void findDifference_twoIntegerLists_totalDifference() throws FileNotFoundException {
        final var lists = Day1.buildLists(new File("main\\test\\resource\\day1TestInput.txt"));
        assertEquals(11, Day1.findDifference(lists));
    }

}
