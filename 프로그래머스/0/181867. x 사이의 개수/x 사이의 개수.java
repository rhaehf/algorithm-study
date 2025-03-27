import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        
        for (char ch : myString.toCharArray()) {
            if (ch == 'x') {
                list.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        list.add(count);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}