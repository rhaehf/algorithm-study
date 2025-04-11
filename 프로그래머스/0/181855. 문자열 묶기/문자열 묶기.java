import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(String str : strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }
        //System.out.println("[Key]:" + 1 + " [Value]:" + map.get(1));
        
         Integer maxValue = Collections.max(map.values());
        return maxValue;
    }
}