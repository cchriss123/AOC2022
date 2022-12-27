import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Day3 {
    public static void main(String[] args) throws IOException {

        List<String> backPack = Files.readAllLines(Path.of("src/input03.txt"));
        List<String> compartmentOne = new ArrayList<>();
        List<String> compartmentTwo = new ArrayList<>();

        backPack.forEach(s -> {
            int halfSize = s.length() / 2;
            String s1 = s.substring(0, halfSize);
            String s2 = s.substring(halfSize);
            compartmentOne.add(s1);
            compartmentTwo.add(s2);
        });

        List<Character> duplicates = findCommonCharacters(compartmentOne, compartmentTwo);
        List<Character> badges = findBadges(backPack);

        System.out.println(sumList(duplicates));
        System.out.println(sumList(badges));


    }


    private static List<Character> findBadges(List<String> backPack) {
        List < Character> badges = new ArrayList<>();

        for (int i = 0; i < backPack.size()-2; i+=3) {
            String s1 = backPack.get(i);
            String s2 = backPack.get(i+1);
            String s3 = backPack.get(i+2);

            badges.add(findCommonChar(s1,s2,s3));
        }
        return badges;
    }


    public static char findCommonChar(String s1, String s2, String s3 ) {
        for (int i = 0; i < s1.length(); i++) {
            if (hasDublicate(s1.charAt(i), s2)){
                if ((hasDublicate(s1.charAt(i), s3)))
                    return s1.charAt(i);
            }
        }
        return ' ';
    }

    private static boolean hasDublicate(char c,  String str) {
        return IntStream.range(0, str.length())
                .mapToObj(str::charAt)
                .filter(ch -> ch == c)
                .anyMatch(ch -> true);
    }


    private static List<Character> findCommonCharacters(List<String> compartmentOne, List<String> compartmentTwo) {

        return IntStream.range(0, compartmentOne.size())
                .mapToObj(i -> {
                    String s1 = compartmentOne.get(i);
                    String s2 = compartmentTwo.get(i);
                    return s1.chars()
                            .filter(c -> s2.indexOf(c) != -1)
                            .mapToObj(c -> (char) c).findFirst().orElse(null);
                })
                .collect(Collectors.toList());
    }


    private static int sumList(List<Character> itemList) {
        String alphabet = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            for (Character j : itemList) {
                if (alphabet.charAt(i) == j)
                    sum += i;
            }
        }
        return sum;
    }

    /*
    //Iterative version of same method.
    private static List<Character> findCommonCharacters(List<String> compartmentOne, List<String> compartmentTwo) {
        List<Character> duplicates = new ArrayList<>();
        for (int i = 0; i < compartmentOne.size(); i++) {
            String s1 = compartmentOne.get(i);
            String s2 = compartmentTwo.get(i);
            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) != -1) {
                    duplicates.add(c);
                    break;
                }
            }
        }
        return duplicates;
    }

     */

}
