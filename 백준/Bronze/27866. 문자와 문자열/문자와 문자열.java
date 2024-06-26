import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int num = Integer.parseInt(br.readLine());
        char[] array = word.toCharArray();

        System.out.println(array[num - 1]);
    }
}