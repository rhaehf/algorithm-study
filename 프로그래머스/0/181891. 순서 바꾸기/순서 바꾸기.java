import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int[] first = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] second = Arrays.copyOfRange(num_list, 0, n);
        
        // System.arraycopy(복사 대상 배열, 복사 대상 배열에서 복사를 시작할 index 위치,
        // 복사 결과를 저장할 대상 배열, 대상 배열에서 복사를 시작할 index 위치, 복사할 요소의 수)
        System.arraycopy(first, 0, answer, 0, first.length);
        System.arraycopy(second, 0, answer, first.length, second.length);
        return answer;
    }
}