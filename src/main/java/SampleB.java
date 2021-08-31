import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SampleB {
    public static void main(String[] args) {
        int a = 0, b = 0;
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))){
            Scanner sc = new Scanner(new File("input.txt"));
            a = sc.nextInt();
            b = sc.nextInt();
            printWriter.print(a + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
