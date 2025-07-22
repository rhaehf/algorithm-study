import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            // 1. n번째 문자가 다르면 해당 문자 기준 정렬
            if (a.charAt(n) != b.charAt(n)) {
                return Character.compare(a.charAt(n), b.charAt(n));
            }
            // 2. 같으면 사전순 정렬
            return a.compareTo(b);
        });

        return strings;
    }
}
