import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] tri = new int[n][n];
        
        // 아래, 오른쪽, 왼쪽 위 대각선 이동 방향
        int[][] dirs = { {1, 0}, {0, 1}, {-1, -1} };
        
        int y = -1, x = 0; // 시작 좌표
        int num = 1; // 입력할 수
        int d = 0; // 방향 인덱스 (0=아래, 1=오른쪽, 2=왼쪽위)
        
        for (int len = n; len >= 1; len--) {
            // 3으로 나눈 나머지를 이용해 방향 계산
            int[] offset = dirs[d % 3];
            int dy = offset[0];
            int dx = offset[1];

            // len 횟수 만큼 수 입력하는 작업
            for (int k = 0; k < len; k++) {
                y += dy;
                x += dx;
                tri[y][x] = num++;
            }

            d++; // 다음 턴에서 사용할 방향으로 이동
        }        
        //System.out.println(Arrays.deepToString(tri));
        
        // 값 입력한 삼각형 부분만 1차원으로 평탄화
        int total = n * (n + 1) / 2; // 채울 총 개수
        
        int[] answer = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = tri[i][j];
            }
        }
        
        return answer;
    }
}
