import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int repeatNum = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char at = word.charAt(j);
                sb.append(String.valueOf(at).repeat(repeatNum));
            }
            System.out.println(sb);
        }
    }
}