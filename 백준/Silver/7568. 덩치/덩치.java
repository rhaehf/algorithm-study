import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int[] weights;
    static int[] heights;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        weights = new int[N];
        heights = new int[N];
        result = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }

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
            result[one] = rate + 1;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }

//        System.out.println(IntStream.of(result).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
//        System.out.println(IntStream.of(result).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}