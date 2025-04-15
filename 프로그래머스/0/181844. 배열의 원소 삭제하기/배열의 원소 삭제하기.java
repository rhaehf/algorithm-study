import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int num : delete_list) {
            // 리스트에서 해당값 삭제
            list.remove((Integer) num);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}