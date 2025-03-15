import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        if(str_list.length == 1)
            return answer;
        
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")){
                // 인덱스 0부터 i까지
                answer = Arrays.copyOf(str_list, i);
                break;
            } else if(str_list[i].equals("r")){
                // 인덱스 i+1부터 끝까지
                answer = Arrays.copyOfRange(str_list, i+1, str_list.length);
                break;
            }
        }
        return answer;
    }
}