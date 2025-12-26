import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeSet(str1);
        Map<String, Integer> map2 = makeSet(str2);
        
        // 집합이 모두 공집합이면 자카드 유사도는 1로 정의한다.
        if (map1.isEmpty() && map2.isEmpty()) return 65536;
        
        int intersection = 0; // 교집합        
        // 교집합 구하기
        for (String key1 : map1.keySet()) {
            // 같은 값을 여러개 가질 때
            if (map2.containsKey(key1))
                intersection += Math.min(map1.get(key1), map2.get(key1));
        }
        
        int union = 0; // 합집합
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        // 합집합 구하기
        for (String key : allKeys) {
            union += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }
        
        // 소수점 아래를 버리고 정수부만 출력
        return (int) Math.floor((double) intersection / union * 65536);
    }
    
    // 다중집합 만들기    
    private static Map<String, Integer> makeSet(String str) {
        Map<String, Integer> multiset = new HashMap<>();
        str = str.toLowerCase(); // 3. 소문자로 바꾸기

        for (int i = 0; i < str.length() - 1; i++) {
            // 1. 문자 2개씩 자르기 
            char a = str.charAt(i); 
            char b = str.charAt(i + 1);
            
            // 2. 영문자만 있는지 확인하기
            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                String s = "" + a + b;
                multiset.put(s, multiset.getOrDefault(s, 0) + 1);
            }
        }

        return multiset;
    }
}
