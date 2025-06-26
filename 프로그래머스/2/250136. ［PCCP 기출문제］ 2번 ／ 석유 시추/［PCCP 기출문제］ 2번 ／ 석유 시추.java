import java.util.*;

class Solution {
    static int height, width; // 땅 세로(행), 가로(열)길이
    static boolean[][] visited; // 방문 체크
    static int[] X = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] Y = {-1, 1, 0, 0};

    public int solution(int[][] land) {
        height = land.length; // 행 개수
        width = land[0].length; // 열 개수
        visited = new boolean[height][width];

        int[] oils = new int[width]; // 각 열에 해당하는 석유량을 누적하는 배열 (열마다 석류량 저장)

        // 모든 좌표를 순회하면서 석유 덩어리 찾기
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // 석유가 있고, 방문하지 않았다면 BFS 수행 (해당 좌표로부터 연결된 부분 탐색)
                if (land[row][col] == 1 && !visited[row][col]) {
                    Set<Integer> columns = new HashSet<>(); // 현재 석유 덩어리가 걸쳐 있는 열들
                    int oil = bfs(row, col, land, columns); // 현재 석유 덩어리 크기 (=석유량)
                    //System.out.println("덩어리 시작 좌표 : " + row + ", "+ col + " -> oil = " + oil);

                    // 탐색한 석유 덩어리에 걸쳐 있는 모든 열에 해당 석유량을 더함
                    for (int c : columns) {
                        oils[c] += oil;
                    }
                    //System.out.println(Arrays.toString(oils)); // 덩어리를 탐색하고나서 확인용
                }
            }
        }

        return Arrays.stream(oils).max().getAsInt();
    }

    // BFS 탐색: 연결된 석유 덩어리를 탐색하며 석유량과 열 정보를 수집
    private int bfs(int startX, int startY, int[][] land, Set<Integer> columns) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY}); // 시작 좌표 추가
        visited[startX][startY] = true; // 방문 체크 완료

        int oil = 1; // 현재 덩어리 석유량
        columns.add(startY); // 시작 열 추가

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 발견한 석유 덩어리의 좌표로 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = x + X[i];
                int nextY = y + Y[i];

                 // 좌표가 땅 범위 안에 들어갈 때만 탐색
                if (0 <= nextX && nextX < height && 0 <= nextY && nextY < width) {
                    // 아직 방문하지 않은 석유 지점이라면 큐에 추가
                    if (land[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true; // 방문 체크 완료
                        queue.offer(new int[]{nextX, nextY}); // 다음에 탐색하기 위해서 큐에 추가
                        oil++; // 석유량 증가
                        columns.add(nextY); // 석유가 분포된 열 정보 추가
                    }
                }
            }
        }

        return oil;
    }
}
