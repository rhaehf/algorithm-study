import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] cardList = br.readLine().split(" ");
        int[] cards = Arrays.stream(cardList).mapToInt(Integer::parseInt).toArray();
//        System.out.println(Arrays.toString(cards));

        int max = 0;

        // 브루트포스 알고리즘 사용
        // 3개의 카드를 고르기 때문에 첫번째 카드 i는 N-2까지 순회
        for (int i = 0; i < N - 2; i++) {
            // 두번째 카드 j는 i 다음부터 N-1까지 순회
            for (int j = i + 1; j < N - 1; j++) {
                // 세번재 카드 k는 j 다음부터 N까지 순회
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}