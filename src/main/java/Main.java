import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(file);){
            int nextSymb = inputStream.read();
            while (nextSymb!=-1){
                System.out.print((char) nextSymb);
                nextSymb = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
