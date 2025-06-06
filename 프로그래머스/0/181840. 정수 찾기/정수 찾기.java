import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list, int n) {
        // anyMatch : 최소 한 개의 요소가 조건에 만족하는지 true, false 반환
        // return Arrays.stream(num_list).anyMatch(x -> x == n) ? 1 : 0;
        return IntStream.of(num_list).anyMatch(num -> num == n) ? 1 : 0;
    }
}
