import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char alpha = 97; // 소문자 a
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            st.append(word.indexOf(alpha + i)).append(" ");
        }
        System.out.println(st);
    }
}