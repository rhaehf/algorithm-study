import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int num : delete_list) {
            if(list.contains(num)) {
                int idx = list.indexOf(num);
                list.remove(idx);
            }           
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}