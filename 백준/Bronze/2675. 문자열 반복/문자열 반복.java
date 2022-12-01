//package P2675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<String> sentence = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String words = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length(); j++) {
                char at = words.charAt(j);
                for (int k = 0; k < repeat; k++) {
                    sb.append(at);
                }
            }
            sentence.add(sb.toString());
        }
        String result = String.join( "\n", sentence);
        System.out.println(result);
    }
}
