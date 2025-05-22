import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 1. n번째 문자가 다르면 그 문자 기준 정렬
                if (a.charAt(n) != b.charAt(n)) {
                    return Character.compare(a.charAt(n), b.charAt(n));
                }
                // 2. n번째 문자가 같으면 사전순 정렬
                return a.compareTo(b);
            }
        });

        return strings;
    }
}
