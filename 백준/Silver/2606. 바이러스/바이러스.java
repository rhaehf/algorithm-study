import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph; // 그래프 배열
    static boolean[] visit; // 방문 체크 배열
    static int virus = 0; // 바이러스에 걸린 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int connection = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 수

        // 인덱스 1번부터 사용
        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 그래프인 문제에서는 꼭 두 방향의 연결을 모두 표현해야함
            graph[a][b] = 1;
            graph[b][a] = 1; // 양방향 연결을 표현하기 위해 반대로도 표시해줌
        }

        bfs(1);
    }

    public static void bfs(int start) { // 너비 우선 탐색 구현
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 1. 큐에 시작 노드 add
        visit[start] = true; // 2. 방문 처리

        while (!queue.isEmpty()) { // 3-1. 큐가 비어있는지 확인 (비어있다면 탐색 종료)
            int computer = queue.poll(); // 3-2. 큐에서 노드를 poll
            for (int i = 0; i < graph.length; i++) { // poll한 노드와 인접한 노드 찾기
                if (graph[computer][i] == 1 && visit[i] == false) { // 3-3. 인접해있고 && 방문하지 않았다면
                    queue.add(i); // 3-4. 아직 방문하지 않은 노드를 큐에 add 하고
                    visit[i] = true; // 3-5. 방문 처리
                    virus++; // 인접해있기에 바이러스에 감염됨
                }
            }
        }
        System.out.println(virus);
    }
}
