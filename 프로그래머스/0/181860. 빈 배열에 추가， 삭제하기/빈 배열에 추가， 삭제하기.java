import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < flag.length; i++) {
            int num = arr[i];

            if (flag[i]) {
                int index = num * 2;
                while (index-- > 0)
                    list.add(num);
            } else {
                int index = num;
                while (index-- > 0)
                    list.remove(list.size() - 1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}