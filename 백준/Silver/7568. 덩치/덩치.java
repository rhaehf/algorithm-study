import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] weights;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        weights = new int[N];
        heights = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int one = 0; one < N; one++) {
            int w1 = weights[one];
            int h1 = heights[one];

            int rate = 0;

            for (int two = 0; two < N; two++) {
                int w2 = weights[two];
                int h2 = heights[two];

                if (one == two) {
                    continue;
                }

                if (w1 < w2) {
                    if (h1 < h2) {
                        rate++;
                    }
                }
            }
            sb.append(rate + 1).append(" ");
        }

        System.out.println(sb);
    }
}