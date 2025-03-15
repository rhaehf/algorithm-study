import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        //int[] first = Arrays.copyOfRange(num_list, n, num_list.length);
        //int[] second = Arrays.copyOfRange(num_list, 0, n);
        
        // System.arraycopy(복사 대상 배열, 복사 대상 배열에서 복사를 시작할 index 위치,
        // 복사 결과를 저장할 대상 배열, 대상 배열에서 복사를 시작할 index 위치, 복사할 요소의 수)
        // n 번째 이후의 원소 복사
        System.arraycopy(num_list, n, answer, 0, num_list.length - n);
        
        // n 번째 까지의 원소 복사
        System.arraycopy(num_list, 0, answer, num_list.length - n, n);
        
        //System.arraycopy(first, 0, answer, 0, first.length);
        //System.arraycopy(second, 0, answer, first.length, second.length);
        return answer;
    }
}