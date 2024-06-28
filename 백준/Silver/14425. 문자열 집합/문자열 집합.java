import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] array = new String[M];
        for (int i = 0; i < M; i++) {
            array[i] = br.readLine();
        }

        int count = 0;
        for (String find : array) {
            if (set.contains(find)) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}