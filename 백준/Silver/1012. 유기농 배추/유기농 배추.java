import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map; // 배추밭
    static boolean[][] visit; // 방문 체크
    static int M; // 배추밭의 가로 길이
    static int N; // 배추밭의 세로 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치 개수

            map = new int[M][N];
            visit = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()); // 배추가 심어지는 가로 위치
                int y = Integer.parseInt(st.nextToken()); // 배추가 심어지는 세로 위치

                map[x][y] = 1;
            }

            int earthworm = 0; // 테스트 케이스마다 지렁이 개수 세기
            // 시작 좌표를 세팅해서 다른 곳에 모여있는 배추들도 파악할 수 있게한다.
            for (int j = 0; j < M; j++) { // 가로
                for (int k = 0; k < N; k++) { // 세로
                    if (map[j][k] == 1 && !visit[j][k]) {
                        // 배추가 있고, 방문 안한 좌표에서부터 bfs로 연결된 곳을 파악
                        bfs(j, k);

                        // 지렁이의 개수는 인접한 곳마다 1개씩이다.
                        // 인접한 곳을 모두 파악했으면 지렁이 개수 1 증가
                        earthworm++;
                    }
                }
            }
            System.out.println(earthworm);
        }
    }

    public static void bfs(int startX, int startY) {
        // bfs가 1번 실행될때마다 인접한 곳을 모두 탐색하고 종료되니 bfs안에 queue를 선언했다.
        Queue<int[]> queue = new LinkedList<>();
        // x, y좌표 저장
        queue.offer(new int[]{startX, startY});
        // 시작 좌표엔 배추가 있으니 미리 true로 처리한다.
        visit[startX][startY] = true;

        // 배추가 상하좌우에 인접하면 이동할 수 있다.
        // 현재 좌표에서 상하좌우 움직일 좌표 지정
        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};

        //queue가 비어있으면 더이상 인접한 배추가 없다는 뜻이다.
        while (!queue.isEmpty()) {
            // 저장된 queue 꺼내기
            int[] node = queue.poll();
            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nowX = node[0] + X[i];
                int nowY = node[1] + Y[i];

                // 좌표가 배추밭을 벗어나게되면 다음 좌표를 체크
                if (nowX < 0 || nowX >= M || nowY < 0 || nowY >= N) {
                    continue;
                }

                // 상하좌우 움직인 좌표에 배추가 있고, 체크하지 않은 좌표이면
                if (map[nowX][nowY] == 1 & !visit[nowX][nowY]) {
                    // 좌표를 저장하고
                    queue.offer(new int[]{nowX, nowY});
                    // 방문 체크를 함
                    visit[nowX][nowY] = true;
                }
            }
        }
    }
}
