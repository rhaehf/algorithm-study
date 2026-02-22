class Solution {
    private char[][] block;
    private int m, n;
    private int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        block = new char[m][n];
        
        // 1. 게임판 만들기
        for (int i = 0; i < m; i++)
            block[i] = board[i].toCharArray();
        
        int totalRemoved = 0;
        
        while(true) {
            // 2. 2×2 블록 찾기 + 지우기
            int removed = play();
            // 턴에서 지워진 블록이 0개면(= 더이상 지울게 없으면) 종료
            if (removed == 0) break;
            
            totalRemoved += removed;
            // 3. 지워진 빈 공간 채우기
            dropBlock();
        }
        
        return totalRemoved;
    }
    
    private int play() {
        boolean[][] check = new boolean[m][n]; // 지울 위치 체크
        
        //  1. 전체 순회하며 2×2 형태의 블록 찾기
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = block[i][j]; // 비교할 블럭                
                // 지워지지 않았고, 2×2 형태이면 지울 위치 따로 저장하기
                if (c != '-' && c == block[i][j + 1] && c == block[i + 1][j] && c == block[i + 1][j + 1]) {
                    check[i][j] = check[i][j + 1] = check[i + 1][j] = check[i + 1][j + 1] = true;
                }
            }
        }
        
        // 2. 게임판에서 블럭 지우고, 지운 개수 반환
        int removed = removeBlock(check, m, n);
        
        return removed;
    }
    
    private int removeBlock(boolean[][] check, int m, int n) {
        int count = 0; // 지운 블럭 수
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 지워야하는 위치이면 게임판에 지운 표시하고, 개수 증가
                if (check[i][j]) {
                    count++;
                    block[i][j] = '-';
                }
            }
        }
        
        return count;
    }
    
    private void dropBlock() {
        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1; // 채워야할 위치

            // 각 열마다 아래에서 위로 채우기
            for (int i = m - 1; i >= 0; i--) {
                // 현재 위치가 블록이면
                if (block[i][j] != '-') {
                    // 블럭을 위에서 아래로 옮김
                    block[emptyRow][j] = block[i][j];
                    
                    // 기존 위치를 없는 표시로 바꿈
                    if (emptyRow != i) {
                        block[i][j] = '-';
                    }
                    emptyRow--; // 위치가 올라감
                }
            }
        }
    }    
}
