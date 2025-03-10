import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lastNum = -1; // 큐는 FIFO라서 가장 최근 값을 기억해두었다가 "back"에서 활용한다.

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    lastNum = Integer.parseInt(st.nextToken());
                    queue.add(lastNum);
                    break;
                case "pop":
                    if (queue.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        sb.append(-1).append("\n");
                    else // 가장 뒤에 있는 수 출력은 가장 최근에 저장한 수를 출력하는 것과 같다.
                        sb.append(lastNum).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
