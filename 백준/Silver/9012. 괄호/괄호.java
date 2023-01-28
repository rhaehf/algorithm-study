import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String result = "";
            Stack<Character> myStack = new Stack<Character>();

            char input[] = br.readLine().toCharArray();
            
            for (int j = 0; j < input.length; j++) {
                char c = input[j];

                if (c == '(') {
                    myStack.push(c);
                }
                else if (myStack.isEmpty()) {
                    result = "NO";
                    break;
                }
                else {
                    myStack.pop();
                }
            }

            if (!result.equals("NO") && myStack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}