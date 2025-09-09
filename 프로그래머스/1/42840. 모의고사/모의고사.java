import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int a = answers[i];
            if (a == one[i % one.length]) score[0]++;
            if (a == two[i % two.length]) score[1]++;
            if (a == three[i % three.length]) score[2]++;
        }
        
        // 가장 높은 점수 찾기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 우승자 수 최대 3명이므로 고정 배열로 만들고 잘라서 반환
        int[] winners = new int[3];
        int k = 0; // 우승자의 수
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) winners[k++] = i + 1;
        }
        
        // 실제 우승자 수만큼 복사해서 새로운 배열로 반환
        return Arrays.copyOf(winners, k);
    }
}
