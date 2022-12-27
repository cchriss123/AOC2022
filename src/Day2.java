import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {

        //a rock, b paper, c scissor
        int xRock = 1;
        int yPaper = 2;
        int zScissors = 3;
        int win = 6;
        int tie = 3;
        int pointCounter1 = 0;
        int pointCounter2 = 0;

        List<String> guideList = Files.readAllLines(Path.of("src/input02.txt"));

        for (String one : guideList) {
            switch (one) {
                case "A X" -> pointCounter1 += (xRock + tie);
                case "A Y" -> pointCounter1 += (yPaper + win);
                case "A Z" -> pointCounter1 += zScissors;
                case "B X" -> pointCounter1 += xRock;
                case "B Y" -> pointCounter1 += (yPaper + tie);
                case "B Z" -> pointCounter1 += (zScissors + win);
                case "C X" -> pointCounter1 += (xRock + win);
                case "C Y" -> pointCounter1 += yPaper;
                case "C Z" -> pointCounter1 += (zScissors + tie);
            }
        }

        for (String two : guideList) {
            switch (two) {
                case "A X" -> pointCounter2 += zScissors;
                case "A Y" -> pointCounter2 += (tie + xRock);
                case "A Z" -> pointCounter2 += (win + yPaper);
                case "B X" -> pointCounter2 += xRock;
                case "B Y" -> pointCounter2 += (tie + yPaper);
                case "B Z" -> pointCounter2 += (win + zScissors);
                case "C X" -> pointCounter2 += yPaper;
                case "C Y" -> pointCounter2 += (tie + zScissors);
                case "C Z" -> pointCounter2 += (win + xRock);
            }
        }
        System.out.println(pointCounter1);
        System.out.println(pointCounter2);
    }
}
