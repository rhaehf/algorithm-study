import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) // 짝수 : 0번 ~ query[i]번 까지
                answer = Arrays.copyOf(answer, query[i] + 1);
            else // 홀수 : query[i]번 부터 ~ 끝까지
                answer = Arrays.copyOfRange(answer, query[i], answer.length);

            // System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
}