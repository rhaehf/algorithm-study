import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            // 입력 종료 조건으로 맨 마지막에 "."이 들어옴
            if (line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                // 아래 부분을 빼도 되는 이유 : break;가 필요 없고, .을 검사하지 않아도 되는 이유는, 괄호 검사가 반드시 . 이전에 완료되기 때문이다.
                /*if (ch == '.') { // 문자열은 온점(".")으로 끝난다.
                    break;
                }*/
                
                if (ch == '(' || ch == '[')
                    stack.push(ch);
                else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop(); // 괄호가 짝을 이룰 때
                    else if (stack.isEmpty()) { // 비어있는 있고, 괄호가 짝을 이루지 않을 때
                        stack.push(ch);
                        break;
                    } else // 괄호가 짝을 이루지 않을 때
                        break;
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else if (stack.isEmpty()) { // 비어있는 있고, 괄호가 짝을 이루지 않을 때
                        stack.push(ch);
                        break;
                    } else // 괄호가 짝을 이루지 않을 때
                        break;
                }
            }

            // 스택이 비어 있고, 모든 괄호가 올바르게 짝을 이루었을 때 "yes", 그렇지 않으면 "no"
            sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
