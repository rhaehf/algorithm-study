import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[][] map; // 지도
    static boolean[][] visit; // 방문 체크
    static int N; // 지도 사이즈 (정사각형이다.)
    static PriorityQueue<Integer> housecount = new PriorityQueue<>(); // 단지내 집의 수를 저장한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 각 줄의 문자열 읽기
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 각 문자를 정수로 변환하여 저장
            }
        }

        int house = 0; // 단지 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    house++;
                }
            }
        }

        StringBuilder st = new StringBuilder();
        st.append(house).append('\n');
        while (!housecount.isEmpty()) {
            st.append(housecount.poll()).append('\n');
        }
        System.out.println(st);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        // 시작점 좌표 저장
        queue.offer(new int[]{startX, startY});
        // 시작점은 방문 처리 해줌
        visit[startX][startY] = true;

        // 상하좌우로 이동할 좌표
        int[] X = {0, 0, -1, 1};
        int[] Y = {1, -1, 0, 0};

        int count = 0; // 한 단지 내의 집의 수
        while (!queue.isEmpty()) {
            // 저장된 좌표 꺼내기
            int[] node = queue.poll();
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                // 상하좌우로 탐색할 좌표 설정
                int nowX = node[0] + X[i];
                int nowY = node[1] + Y[i];

                // 지도 범위를 벗어나면 다음 좌표로 넘어감
                if (nowX < 0 || N <= nowX || nowY < 0 || N <= nowY) {
                    continue;
                }

                // 상하좌우로 움직인 좌표에 집이 있고, 체크하지 않은 좌표라면
                if (map[nowX][nowY] == 1 && !visit[nowX][nowY]) {
                    queue.offer(new int[]{nowX, nowY}); // 해당 좌표를 큐에 저장하고
                    visit[nowX][nowY] = true; // 방문 체크를 함
                }
            }
            count++; // 단지내 집의 수 증가
        }
        housecount.offer(count);
    }
}
