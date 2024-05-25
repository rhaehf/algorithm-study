import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph; // 그래프 배열
    static boolean[] visit; // 방문 체크 배열
    static int virusCnt = 0; // 바이러스에 걸린 컴퓨터 수

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

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(1);
        System.out.println(virusCnt - 1);
    }

    static void dfs(int computer) { // 깊이 우선 탐색 구현
        visit[computer] = true; // 1. 방문 처리
        virusCnt++;
//        System.out.print("computer : ");
//        System.out.println(computer);

        for (int i = 0; i < graph.length; i++) {
            if (graph[computer][i] == 1 && visit[i] == false) {
//                System.out.print("인접해있고, 방문하지않은 노드 i : ");
//                System.out.println(i);
                dfs(i); // 2. 내부적으로 재귀 호출
            }
        }
    }
}