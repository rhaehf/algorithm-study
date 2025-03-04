import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int passNum = 1; // 통과할 번호
        Stack<Integer> waitingLine = new Stack<>(); // 대기줄

        String[] numArray = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int currentNum = Integer.parseInt(numArray[i]); // 현재줄의 번호표

            if (currentNum == passNum) { // 통과할 번호와 현재줄의 번호표가 같을 때
                passNum++;
            } else {
                // 통과할 번호가 대기줄에 있는지 확인
                if (!waitingLine.isEmpty() && waitingLine.peek() == passNum) {
                    passNum++;
                    i--; // 대기줄에서 처리했기에 현재줄의 남은 처리를 위해서 횟수를 돌려놀음
                    waitingLine.pop();
                } else
                    waitingLine.push(currentNum);
            }
        }

        while (!waitingLine.isEmpty()) {
            if (waitingLine.pop() == passNum) {
                passNum++;
            } else
                break;
        }

        System.out.println(waitingLine.isEmpty() ? "Nice" : "Sad");
    }
}
