import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];
        int a2 = intervals[1][0];
        int b2 = intervals[1][1];
        
        int[] one = Arrays.copyOfRange(arr, a1, b1+1);
        int[] two = Arrays.copyOfRange(arr, a2, b2+1);
        int[] copy = new int[one.length + two.length];
        
        // System.arraycopy(복사 대상 배열, 복사 대상 배열에서 복사를 시작할 index 위치,
        // 복사 결과를 저장할 대상 배열, 대상 배열에서 복사를 시작할 index 위치, 복사할 요소의 수)
        System.arraycopy(one, 0, copy, 0, one.length);
        System.arraycopy(two, 0, copy, one.length, two.length);
        return copy;
    }
}