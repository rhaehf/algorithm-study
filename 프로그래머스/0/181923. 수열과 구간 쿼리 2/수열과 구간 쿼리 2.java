import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int idx = 0;
        int[] answer = new int[queries.length];

        for (int[] query : queries) {
            int s = query[0], e = query[1], k = query[2];
            int min = Integer.MAX_VALUE;

            for (int i = s;i <= e;i++)
                if (arr[i] > k)
                    min = Math.min(arr[i], min);

            answer[idx++] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return answer;
        // 아래는 내 풀이
 /*       List<Integer> result = new ArrayList<>();
        
        for(int[] query : queries){
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int[] answer = Arrays.copyOfRange(arr, s, e+1);
            List<Integer> minList = new ArrayList<>();
            for(int a : answer){
                if(k < a){
                    minList.add(a);
                }
            }            
            int minNum = minList.stream().mapToInt(v -> v).min().orElse(-1);
            result.add(minNum);
        }
        return result.stream()
                .mapToInt(i -> i)
                .toArray(); */
    }
}