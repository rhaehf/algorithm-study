import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());

            int X = 0; // order가 1일떼 넣을 값
            if (order == 1) {
                X = Integer.parseInt(st.nextToken());
            }

            switch (order) {
                case 1:
                    stack.add(X);
                    break;
                case 2:
                    if (stack.empty()) {
                        sb.append("-1").append("\n");
//                        System.out.println(-1);
                    } else {
                        sb.append(stack.pop()).append("\n");
//                        System.out.println(stack.pop());
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
//                    System.out.println(stack.size());
                    break;
                case 4:
                    if (stack.empty()) {
                        sb.append("1").append("\n");
//                        System.out.println(1);
                    } else{
                        sb.append("0").append("\n");
//                        System.out.println(0);
                    }
                    break;
                case 5:
                    if (stack.empty()) {
                        sb.append("-1").append("\n");
//                        System.out.println(-1);
                    } else {
                        sb.append(stack.peek()).append("\n");
//                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}