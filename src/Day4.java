import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Day4 {
    public static void main(String[] args) throws IOException {

        List<ElfPair> elfPairs = Files.readAllLines(Path.of("src/input04.txt"))
                .stream()
                .map(s -> {
                    String[] ranges = s.split(",");
                    String[] firstRange = ranges[0].split("-");
                    String[] secondRange = ranges[1].split("-");
                    ElfPair pair = new ElfPair();
                    pair.firstStart = Integer.parseInt(firstRange[0]);
                    pair.firstEnd = Integer.parseInt(firstRange[1]);
                    pair.secondStart = Integer.parseInt(secondRange[0]);
                    pair.secondEnd = Integer.parseInt(secondRange[1]);
                    return pair;
                }).toList();

        long part1 = elfPairs.stream()
                .filter (elfPair ->
                        (elfPair.firstStart <= elfPair.secondStart && elfPair.firstEnd >= elfPair.secondEnd)
                        ||
                        (elfPair.firstStart >= elfPair.secondStart && elfPair.firstEnd <= elfPair.secondEnd))
                .count();

        long part2 = elfPairs.stream()
                .filter(elfPair ->
                        (elfPair.firstEnd >= elfPair.secondStart && elfPair.secondEnd >= elfPair.firstStart))
                .count();

        System.out.println("Part 1: " + part1 + ", Part 2: " + part2);


    }
/*
    private static int part1(List<ElfPair> elfPairs) {
        int sum = 0;
        for (ElfPair elfPair : elfPairs) {
            if (elfPair.firstStart <= elfPair.secondStart && elfPair.firstEnd >= elfPair.secondEnd)
                sum += 1;
            else if
            (elfPair.firstStart >= elfPair.secondStart && elfPair.firstEnd <= elfPair.secondEnd)
                sum += 1;
        }
        return sum;
    }

    private static int part2(List<ElfPair> elfPairs) {
        int sum = 0;
        for (ElfPair elfPair : elfPairs) {
            if ((elfPair.firstEnd >= elfPair.secondStart) && (elfPair.secondEnd >= elfPair.firstStart))
                sum += 1;
        }
        return sum;
    }

 */

}


class ElfPair{
    int firstStart;
    int firstEnd;
    int secondStart;
    int secondEnd;
}







