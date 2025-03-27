import java.util.*;

class Solution {
    public String[] solution(String myString) {
        // 두번째 풀이
        return Arrays.stream(myString.split("x")).filter(s -> !s.isEmpty()).sorted().toArray(String[]::new);
        
        /*
        // 첫번째 풀이
        String[] answer = myString.split("x");
        // split 사용시 "xaxbxcx" 을 처리하면 ["","a","b","c"]이 나온다.
        
        ArrayList<String> list = new ArrayList<>();
        // 공백 제거 작업
        for(String s : answer) {
            if(!s.equals(""))
                list.add(s);
        }
            
        Collections.sort(list);
        return list.toArray(String[]::new);
        */
    }
}