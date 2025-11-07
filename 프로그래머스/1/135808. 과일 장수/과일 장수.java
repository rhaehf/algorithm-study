import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int total = score.length; // 전체 사과 개수
        int boxCount = total / m; // 판매할 수 있는 상자 개수
        
        Arrays.sort(score);        
        int answer = 0;
        int idx = total;
        while (boxCount-- > 0) {
            idx -= m;
            answer += score[idx] * m;
        }
        
        return answer;
    }
}
