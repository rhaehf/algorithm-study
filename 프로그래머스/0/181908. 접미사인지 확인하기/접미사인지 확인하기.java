import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        // 두번째 방법
        // endsWith() 메서드는 문자열이 특정 접미사(suffix)로 끝나는지 여부를 확인하는 메서드이다.
        return my_string.endsWith(is_suffix) ? 1 : 0;
        
        // 첫번째 방법
        /*
        List<String> suffixList = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            suffixList.add(my_string.substring(i));
        }

        return suffixList.contains(is_suffix) ? 1 : 0;
        */
    }
}