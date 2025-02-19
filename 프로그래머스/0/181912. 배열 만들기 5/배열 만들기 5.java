import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if (num > k)
                list.add(num);
        }
        
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}