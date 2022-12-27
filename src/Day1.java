import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<Integer> elfs = Arrays.stream(Files.readString(Path.of("src/input01.txt")).split("\\n\\n"))
                .map(s -> Arrays.stream(s.split("\\n"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Högsta nummret: " + elfs.get(0));
        System.out.println("Top 3:" + (elfs.get(0) + elfs.get(1) + elfs.get(2)));
    }
}
