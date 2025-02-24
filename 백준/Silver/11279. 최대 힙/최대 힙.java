import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty())
                    // 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력
                    sb.append(0).append("\n");
                else {
                    sb.append(pq.peek()).append("\n"); // 가장 큰 값 출력하고
                    pq.poll(); // 제거
                }
            } else {
                pq.add(x); // 큐에 x 값 넣기
            }
        }
        System.out.println(sb.toString().trim());
    }
}
