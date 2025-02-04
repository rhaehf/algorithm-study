import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int quotient = N / 5; // 5로 나누었을 때 몫
        int result = -1;

        // 5로 나누었을 때 몫을 줄여나가면서 최소 개수를 구함
        for (int i = quotient; 0 <= i; i--) {
            int newQuotient = (N - i * 5); // i에 따라서 3으로 나눌 수 재정의
            int step = newQuotient / 3;
            // 재정의한 값을 3으로 나누었을 때 나머지가 0으로 값이 떨어진다면
            // 그 몫(step)을 그 시점의 for문의 5로 나누었을 때 몫(i)과 더한다.
            if (newQuotient % 3 == 0) {
                result = step + i;
                break;
            }
        }
        System.out.println(result);
    }
}
