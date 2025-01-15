import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 블로그 시작한 일수
        int X = Integer.parseInt(st.nextToken()); // 몇 일동안의 방문자 수를 구할건지 기간

        int[] days = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        int visitCount = 0; // 방문자 수의 합
        int maxVisit = 0; // 최대 방문자 합의 횟수
        int count = 0; // 최대 방문자 수를 기록한 횟수

        // 처음 X일 동안 방문자 수의 합
        for (int i = 0; i < X; i++) {
            visitCount += days[i];
        }
        maxVisit = visitCount;

        // 최대 방문자 수가 0명이 아닌 경우 최대 방문자 수 기록은 최소 1이 된다.
        if (maxVisit != 0)
            count = 1;

        // 슬라이딩 윈도우(투 포인터) 사용
        for (int i = X; i < days.length; i++) {
            visitCount = visitCount - days[i - X] + days[i];

            if (visitCount == maxVisit)
                count++;
            else if (visitCount > maxVisit) {
                maxVisit = visitCount;
                count = 1; // 새로운 최대 방문자 수가 갱신되면 초기화
            }
        }

        if (maxVisit == 0)
            System.out.println("SAD");
        else {
            System.out.println(maxVisit);
            System.out.println(count);
        }
    }
}
