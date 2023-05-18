import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("folder1/folder2/folder3/empty_file1.txt");
        File file2 = new File("folder1/folder2/folder3/empty_file2.txt");
        File file3 = new File("folder1/folder2/folder3/empty_file3.txt");
        File file4 = new File("folder1/folder2/folder3/empty_file4.txt");
        File directory = new File("folder1/folder2/folder3");
        try {
            directory.mkdirs();
            file3.createNewFile();
            file4.createNewFile();
            file2.createNewFile();
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] listFiles= directory.list(((dir, name) ->name.contains("1")));
        for (String i : listFiles){
            System.out.println(i);
        }
        System.out.println(file1.exists());
    }
}
