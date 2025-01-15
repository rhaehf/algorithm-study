import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 전체 숫자 개수
        int K = Integer.parseInt(st.nextToken()); // 연속적인 합을 구하는 개수

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0; // 합이 최대가 되는 값
        int currentSum = 0; // 수열에서 K길이 만큼 더한 값
        for (int i = 0; i < K; i++) {
            currentSum += nums[i];
        }
        maxSum = currentSum;

        // 슬라이딩 윈도우(투 포인터) 사용
        for (int i = K; i < nums.length; i++) {
            currentSum = currentSum - nums[i - K] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);
    }
}
