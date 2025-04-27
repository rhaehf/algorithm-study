class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        // 이동 방향: 오른쪽 → 아래 → 왼쪽 → 위
        int[] dx = {0, 1, 0, -1}; // 행 변화량
        int[] dy = {1, 0, -1, 0}; // 열 변화량
        
        int x = 0, y = 0; // 시작 위치
        int dir = 0;      // 시작 방향 (오른쪽)
        int num = 1;      // 채워나갈 숫자
        
        while (num <= n * n) {
            answer[x][y] = num++; // 현재 위치에 숫자 채우기
            
            // 다음 위치 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 범위를 벗어나거나, 이미 숫자가 채워져 있다면
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환 : 오른쪽 → 아래 → 왼쪽 → 위 순서로 회전
                nx = x + dx[dir]; // 전환된 방향으로 다시 이동 좌표 계산
                ny = y + dy[dir];
            }
            
            // 이동
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}
