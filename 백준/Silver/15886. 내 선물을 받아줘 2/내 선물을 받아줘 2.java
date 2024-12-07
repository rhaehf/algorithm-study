import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] move = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < move.length; i++) {
            if (move[i] == 'E' && move[i + 1] == 'W')
                count++;
        }
        System.out.println(count);
    }
}
