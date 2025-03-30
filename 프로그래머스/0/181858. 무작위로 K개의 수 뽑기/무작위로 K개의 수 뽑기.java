import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(list.size() == k)
                break;
            
            if(!list.contains(arr[i]))
                list.add(arr[i]);
        }

        if (list.size() < k) {
            int num = k - list.size();
            while(num-- > 0)
                list.add(-1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}