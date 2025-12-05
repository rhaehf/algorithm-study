import java.util.*;

class Solution {    
    public int solution(int[] mats, String[][] park) {
        // 공원 사이즈 측정
        int height = park.length; // y
        int width = park[0].length; // x
        
        Arrays.sort(mats); // 돗자리 크기 오름차순 정렬
        int answer = 0;
        // 돗자리 정렬 후 큰 값부터 깔 수 있는지 검사
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];
            
            // 돗자리의 왼쪽 위를 시작점(y, x)으로 생각하며 공원을 완전 탐색
            for (int i = 0; i <= height - size; i++) {
                for (int j = 0; j <= width - size; j++) {
                    if (canPlace(i, j, size, park))
                        return size;
                }                
            }           
        }
        // 아무 돗자리도 깔 수 없으면 
        return -1;
    }
    
    // 시작점(y, x)에서 size x size 돗자리 깔 수 있는지 확인
    private boolean canPlace(int y, int x, int size, String[][] park) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}
