import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph; // 그래프 배열
    static boolean[] visit; // 방문 체크 배열

    static int virusCnt; // 바이러스에 걸린 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCnt = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int lineCnt = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 수

        graph = new int[computerCnt + 1][computerCnt + 1];
        visit = new boolean[computerCnt + 1];

        for (int i = 0; i < lineCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 배열이기때문에 대칭적으로 값 넣어주기
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        bfs(1);
    }

    static void bfs(int start) { // 너비 우선 탐색 구현
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start); // 1. 큐에 시작 노드 add
        visit[start] = true; // 2. 방문 처리

        while (!queue.isEmpty()) { // 3-1. 큐가 비어있는지 확인 (비어있다면 탐색 종료)
            int pollNum = queue.poll(); // 3-2. 큐에서 노드를 poll

            for (int i = 1; i < graph.length; i++) { // 3-3. poll한 노드와 인접한 모든 노드를 확인
                if (graph[pollNum][i] == 1 && visit[i] == false) { // 인접해있고 && 방문하지 않았다면
                    queue.add(i); // 3-4. 아직 방문하지 않은 노드를 큐에 add 하고
                    visit[i] = true; // 3-5. 방문처리
                    virusCnt++;
                }
            }
        }

        System.out.println(virusCnt);
    }
}
