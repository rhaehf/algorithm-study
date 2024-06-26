import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String sentence = br.readLine();
            char first = sentence.charAt(0);
            char end = sentence.charAt(sentence.length() -1);

            System.out.print(first);
            System.out.println(end);
        }
    }
}