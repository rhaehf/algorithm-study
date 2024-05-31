import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sbArray;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sbArray = new int[M]; // StringBuilder로 만들기 전에 답을 담는 임시 배열
        visit = new boolean[N + 1]; // 0번째 요소 사용 안함

        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int step) {
        if (step == m) { // step이 m과 같아지면 sbArray 배열의 값을 StringBuilder에 넣기
            for (int num : sbArray) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == false) { // 1. 방문 확인
                visit[i] = true; // 2. 방문 처리
                sbArray[step] = i; // 3. 탐색한 값을 step을 인덱스로한 sbArray에 값 넣기
                dfs(n, m, step + 1); // 4. 다음 자식 노드 방문을 위해 단계를 +1 해서 재귀 호출
                visit[i] = false; // 5. 자식 노드를 방문하고 오면 방문하지 않은 상태로 다시 변경
            }
        }
    }
}