class Solution {
    int zero = 0;
    int one = 0;
    int[][] A;

    public int[] solution(int[][] arr) {
        this.A = arr;
        dfs(0, 0, arr.length); // 분할 탐색
        return new int[] { zero, one };
    }

    private void dfs(int x, int y, int size) {
        if (isSame(x, y, size)) { // 구역의 숫자가 같은지
            if (A[y][x] == 0) zero++;
            else one++;
            return;
        }
        
        int half = size / 2;
        // 4등분으로 나눠서 각각 dfs 재귀 호출
        dfs(x, y, half); // 왼쪽 위
        dfs(x + half, y, half); // 오른쪽 위
        dfs(x, y + half, half); // 왼쪽 아래
        dfs(x + half, y + half, half); // 오른쪽 아래
    }

    private boolean isSame(int x, int y, int size) {
        int first = A[y][x]; // 해당 구역의 첫번째 값
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (A[i][j] != first) return false; // 다른 값이 나오면 탐색 중단
            }
        }
        return true;
    }
}
