import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class Day6 {
    public static void main(String[] args) throws IOException {

        String content = Files.readString(Path.of("src/input06.txt"));
        int part1 = 4;
        int part2 = 14;

        System.out.println(findDistinctChars(content, part2));
    }

    private static long findDistinctChars(String content, int numberOfChars) {

        int firstHit = IntStream.range(numberOfChars, content.length())
                .filter(s -> content.substring(s, s+ numberOfChars).chars().distinct().count() == numberOfChars)
                .findFirst().getAsInt();

        return numberOfChars + firstHit;
    }
}






