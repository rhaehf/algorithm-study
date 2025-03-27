import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // 두번째 풀이
        String[] tmp = myString.split("x");
        for (int i = 0; i < tmp.length; i++) {
            list.add(tmp[i].length());
        }

        if (myString.endsWith("x")) {
            list.add(0);
        }
        
        /*
        // 첫번째 풀이
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
        */
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}