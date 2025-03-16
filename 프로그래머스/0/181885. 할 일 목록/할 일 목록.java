import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < finished.length; i++){
            if (!finished[i]) // false 인 경우
                list.add(todo_list[i]);
        }
        
        return list.toArray(new String[list.size()]);
    }
}