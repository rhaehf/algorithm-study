import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        // 두번째 풀이
        int answer = 0;
        int[] lengArr = new int[31];

        for(int i=0; i<strArr.length; i++) {
            lengArr[strArr[i].length()]++;
        }

        for(int i=0; i<=30; i++) {
            answer = Math.max(answer, lengArr[i]);
        }

        return answer;
        
        /*
        // 첫번째 풀이
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(String str : strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }
        //System.out.println("[Key]:" + 1 + " [Value]:" + map.get(1));
        
         Integer maxValue = Collections.max(map.values());
        return maxValue;
        */
    }
}