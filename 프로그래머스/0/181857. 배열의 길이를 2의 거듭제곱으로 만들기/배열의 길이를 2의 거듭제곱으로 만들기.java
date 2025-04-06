import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int targetLength = 1;

        while (targetLength < arr.length) {
            targetLength *= 2;
        }

        // 자동으로 남은 부분은 0으로 채워짐
        return Arrays.copyOf(arr, targetLength);
        
        /*
        int add = 0;
        for(int i = 1; i <= (1000 - arr.length); i++){
            if(arr.length <= (int)Math.pow(2, i)){
                add = (int)Math.pow(2, i) - arr.length;
                break;
            }
        }        
        
        if(add == 0)
            return arr;
        
        // 새로운 배열 생성 (기본값 0으로 자동 초기화됨)
        int[] answer = new int[arr.length + add];
        
        for(int i = 0; i < arr.length; i++){            
                answer[i] = arr[i];                    
        }
        return answer;
        */
    }
}