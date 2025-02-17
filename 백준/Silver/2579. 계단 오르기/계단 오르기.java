import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단의 개수

        int[] dp = new int[N + 1]; // 계단이 N개일 때 밟은 계단들의 최대 점수 합
        int[] score = new int[N + 1]; // 계단의 점수들

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 반복문(Bottom-Up) 방법

        // 계단이 1개인 경우
        dp[1] = score[1];

        // 계단이 2개인 경우 - 첫번째 + 두번째 모두 밟아야 최댓값이 나온다.
        if (N >= 2) { // N이 1이면 실행하면 안되기에 if문으로 처리
            dp[2] = score[1] + score[2];
        }

        // 계단이 3개인 경우 - 1. 첫번째 + 마지막 2. 두번째 + 마지막 의 경우만 나온다.
        // 세번째인 마지막 계단은 꼭 밟아야 하기때문에 따로 빼서 더해준다.
        if (N >= 3) { // N이 1, 2이면 실행하면 안되기에 if문으로 처리
            dp[3] = Math.max(score[1], score[2]) + score[3];
        }

        // 마지막 계단을 밟기 이전에 밟을 수 있는 계단의 방법은 2가지이다.
        // 1. n-3 → n-1 → n  2. n-2 → n => 2가지 방법을 적용해서 dp 식을 작성한다.
        for (int n = 4; n <= N; n++) {
            dp[n] = Math.max(dp[n - 3] + score[n - 1], dp[n - 2]) + score[n];
        }

        System.out.println(dp[N]);
    }
}
