import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        
        // Arrays.copyOfRange(T[] original, int from, int to)
        // 복사할 배열, 복사할 배열의 시작 인덱스, 복사할 배열의 끝 인덱스
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
}