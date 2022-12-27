import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileToList{
    public static void main(String[] args) throws IOException {

        //Pick one!


        List<String> backPack = Files.readAllLines(Path.of("src/input03.txt"));
        String content = Files.readString(Path.of("src/input01.txt"));

        //worse options bellow





        File file = new File("src/input04.txt");
        Path filePath = Path.of("src/input04.txt");

        List<String> pair = fileToList(file);
        List<String> pair2 = fileToList2(filePath);

        System.out.println(pair);
        System.out.println(pair2);
    }

    private static ArrayList<String> fileToList(File file) {
        ArrayList<String> tempList = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String line;
            while((line = bufferedreader.readLine()) != null) {
                tempList.add(line);
            }
            filereader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return tempList;
    }



    private static List<String> fileToList2(Path filePath) throws IOException {

        String content = Files.readString(filePath);
        StringBuilder builder = new StringBuilder();
        List<String> tempList = new ArrayList<>();

        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) != ('\n')) {
                builder.append(content.charAt(i));
            }
            else {
                tempList.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return tempList;
    }
}
