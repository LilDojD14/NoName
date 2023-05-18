import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        File file = new File("1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file))){
            char[] array = new char[8192];
            int a = reader.read(array);
            StringBuilder result = new StringBuilder();
            while (a>0){
                result.append(new String(array,0,a));
                a = reader.read(array);
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
