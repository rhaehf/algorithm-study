import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] person = new String[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            person[i][0] = st.nextToken(); // 나이
            person[i][1] = st.nextToken(); // 이름
        }

        Arrays.sort(person, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(person[i][0]).append(" ").append(person[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}