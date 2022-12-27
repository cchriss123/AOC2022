import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class Day5 {
    public static void main(String[] args) throws IOException {

        List<String> instructionList = Files.readAllLines(Path.of("src/input05.txt"));
        List<ArrayDeque<Character>> cratePiles = new ArrayList<>();

        ArrayDeque<Character> one = new ArrayDeque<>();
        ArrayDeque<Character> two = new ArrayDeque<>();
        ArrayDeque<Character> three = new ArrayDeque<>();
        ArrayDeque<Character> four = new ArrayDeque<>();
        ArrayDeque<Character> five = new ArrayDeque<>();
        ArrayDeque<Character> six = new ArrayDeque<>();
        ArrayDeque<Character> seven = new ArrayDeque<>();
        ArrayDeque<Character> eight = new ArrayDeque<>();
        ArrayDeque<Character> nine = new ArrayDeque<>();
        List<String> instructionsList = getStrings(instructionList);
        List<Instruction> instructions = instructions(instructionsList);

        cratePiles.add(one);
        cratePiles.add(two);
        cratePiles.add(three);
        cratePiles.add(four);
        cratePiles.add(five);
        cratePiles.add(six);
        cratePiles.add(seven);
        cratePiles.add(eight);
        cratePiles.add(nine);
        addCratesToCratePiles(instructionList, cratePiles);

        //moveTheCrates(cratePiles, instructions);
        moveTheCrates2(cratePiles, instructions);
        System.out.println(getFirstCrates(cratePiles));
    }

    private static String getFirstCrates(List<ArrayDeque<Character>> cratePiles) {
        StringBuilder builder = new StringBuilder();
        for (ArrayDeque<Character> cratePile : cratePiles) {
            builder.append(cratePile.getFirst());
        }
        return builder.toString();
    }

    private static void moveTheCrates(List<ArrayDeque<Character>> cratePiles, List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            for (int j = 0; j < instruction.move; j++) {
                cratePiles.get(instruction.to - 1).addFirst(cratePiles.get(instruction.from - 1).getFirst());
                cratePiles.get(instruction.from - 1).removeFirst();
            }
        }
    }

    private static void moveTheCrates2(List<ArrayDeque<Character>> cratePiles, List<Instruction> instructions) {
        ArrayDeque<Character> temp = new ArrayDeque<>();
        for (Instruction instruction : instructions) {
            for (int j = 0; j < instruction.move; j++) {
                temp.addFirst(cratePiles.get(instruction.from - 1).getFirst());
                cratePiles.get(instruction.from - 1).removeFirst();
            }
            for (int j = 0; j < instruction.move; j++) {
                cratePiles.get(instruction.to - 1).addFirst(temp.getFirst());
                temp.removeFirst();
            }
        }
    }


    private static List<Instruction> instructions(List<String> instructionsList) {
        List<Instruction> instructions = new ArrayList<>();
        for (String s : instructionsList) {
            Instruction instruction = new Instruction();
            for (int j = 0; j < s.length(); j++) {
                String[] tempArray = s.split(",");
                instruction.move = Integer.parseInt(tempArray[0]);
                instruction.from = Integer.parseInt(tempArray[1]);
                instruction.to = Integer.parseInt(tempArray[2]);
            }
            instructions.add(instruction);
        }
        return instructions;
    }

    private static List<String> getStrings(List<String> day5ContentList) {
        List<String> instructionsList = new ArrayList<>();
        for (int i = 10; i < day5ContentList.size(); i++) {
            String temp = day5ContentList.get(i);
            temp = temp.replace("move ", "");
            temp = temp.replace(" from ", ",");
            temp = temp.replace(" to ", ",");
            instructionsList.add(temp);
        }
        return instructionsList;
    }


    private static void addCratesToCratePiles(List<String> day5ContentList, List<ArrayDeque<Character>> deques) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < day5ContentList.get(i).length(); j++) {
                if (day5ContentList.get(8).charAt(j) == '1' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(0).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '2' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(1).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '3' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(2).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '4' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(3).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '5' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(4).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '6' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(5).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '7' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(6).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '8' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(7).add(day5ContentList.get(i).charAt(j));
                else if (day5ContentList.get(8).charAt(j) == '9' && day5ContentList.get(i).charAt(j) != ' ')
                    deques.get(8).add(day5ContentList.get(i).charAt(j));
            }
        }
    }
}

class Instruction{
    int move;
    int from;
    int to;

    @Override
    public String toString() {
        return "Instruction{" +
                "move=" + move +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}






