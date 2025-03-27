import java.util.*;

class Solution {
    public String[] solution(String myString) {
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
    }
}