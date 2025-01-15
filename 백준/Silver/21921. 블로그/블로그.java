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

        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        int visitSum = 0; // 방문자 수의 합
        // 처음 X일 동안 방문자 수의 합
        for (int i = 0; i < X; i++) {
            visitSum += visits[i];
        }

        int maxVisit = visitSum; // 최대 방문자 수
        int count = 1; // 최대 방문자 수를 기록한 횟수

        // 슬라이딩 윈도우(투 포인터) 사용
        for (int i = X; i < visits.length; i++) {
            visitSum = visitSum - visits[i-X] + visits[i];

            // 최대 방문자 수와 동일한 경우
            if(visitSum == maxVisit)
                count++;
            
            // 최대 방문자 수가 갱신된 경우
            if(visitSum > maxVisit){
                maxVisit = visitSum;
                count = 1;
            }
        }

        if(maxVisit == 0)
            System.out.println("SAD");
        else {
            System.out.println(maxVisit);
            System.out.println(count);
        }
    }
}
