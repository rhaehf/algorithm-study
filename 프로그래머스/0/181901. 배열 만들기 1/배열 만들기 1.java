import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        // 두번째 방법
        int count = n / k;

        int[] answer = new int[count];

        for (int i = 1; i <= count; i++) {
            answer[i - 1] = k * i;
        }

        return answer;
        
        // 첫번째 방법
        /*
        List<Integer> answer = new ArrayList<>();
        
        for(int i = k; i <= n; i += k){
            answer.add(i);
        }
        
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
        */
    }
}