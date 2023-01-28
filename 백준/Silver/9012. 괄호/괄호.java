import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String result = "";

        for (int i = 0; i < T; i++) {
            char input[] = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(input));

            Stack<Character> myStack = new Stack<Character>();
            for (int j = 0; j < input.length; j++) {
                char c = input[j];

                if (c == '(') {
                    myStack.push(c);
                }
                else if (myStack.isEmpty()) {
                    result = "NO";
//                    System.out.println("NO !!!");
                    break;
                }
                else {
                    myStack.pop();
                }
//                System.out.println(myStack);
            }

//            System.out.println(myStack);
            if (!result.equals("NO") && myStack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            result = "";
        }
    }
}