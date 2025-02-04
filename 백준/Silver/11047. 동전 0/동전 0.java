import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N]; // K를 나눌 동전의 가치가 들어있는 배열
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int target = K; // 변하는 몫
        for (int i = N-1; 0 <= i; i--) {
            if (nums[i] <= target && target != 0) {
                result += target / nums[i]; // i번째 동전 값으로 나눈 몫
                target = target % nums[i]; // 나눈 값을 뺀 나머지
            }
        }
        System.out.println(result);
    }
}
