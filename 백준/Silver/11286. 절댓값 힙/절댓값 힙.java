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
        PriorityQueue<Integer> plusHeap = new PriorityQueue<>(); // 양수만 담는 힙
        PriorityQueue<Integer> minorHeap = new PriorityQueue<>(Collections.reverseOrder()); // 음수만 담는 힙

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (plusHeap.isEmpty() && minorHeap.isEmpty()) {
                    // 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                    sb.append(0).append("\n");
                } else if (plusHeap.isEmpty()) {
                    sb.append(minorHeap.peek()).append("\n");
                    minorHeap.poll();
                } else if (minorHeap.isEmpty()) {
                    sb.append(plusHeap.peek()).append("\n");
                    plusHeap.poll();
                } else {
                    int positive = Math.abs(plusHeap.peek()); // 양수 값의 절댓값
                    int negative = Math.abs(minorHeap.peek()); // 음수 값의 절댓값

                    // 절댓값이 가장 작은 값을 출력하고, 최소 값 제거
                    if (positive < negative) { // 양수 값의 절댓값이 작은 경우
                        sb.append(plusHeap.peek()).append("\n");
                        plusHeap.poll();
                    } else { // 음수 값의 절댓값이 작거나 양수 값과 음수 값의 절댓값이 같은 경우
                        sb.append(minorHeap.peek()).append("\n");
                        minorHeap.poll();
                    }
                }
            } else {
                if (x < 0)
                    minorHeap.add(x); // 최대 힙에 x 값 넣기
                else
                    plusHeap.add(x); // 최소 힙에 x 값 넣기
            }
        }
        System.out.println(sb.toString().trim());
    }
}
