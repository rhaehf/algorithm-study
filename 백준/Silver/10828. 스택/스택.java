import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 시간 제한이 0.5초이기 때문에
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push": // 정수 X를 스택에 넣기
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop": // 가장 위에 있는 정수를 빼고, 그 수를 출력
                    if (stack.isEmpty()) // 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                        sb.append("-1\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "size": // 스택에 들어있는 정수의 개수를 출력
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty": // 스택이 비어있으면 1, 아니면 0을 출력
                    if (stack.empty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "top": // 스택의 가장 위에 있는 정수를 출력
                    if (stack.isEmpty()) // 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                        sb.append("-1\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
