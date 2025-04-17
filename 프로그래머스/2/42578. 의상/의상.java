import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종류별로 몇 개씩 있는지 저장
        for(String[] cloth : clothes) {
            String key = cloth[1]; // 옷 종류
            map.put(key, map.getOrDefault(key, 0) + 1); // map(옷 종류, 옷 개수)
        }
        
        // 옷 종류가 1개일 때
        if(map.keySet().size() == 1)
            return clothes.length;
        
        int answer = 1;
        for (String key : map.keySet()) {
            // 서로 독립적인 선택을 하는 경우, 경우의 수는 곱한다는 조합의 기본 원리
            answer *= (map.get(key) + 1); // key : 각 종류마다 옷 개수, +1 : 안 입는 경우
            // headgear : 총 3가지 (안입음, yellow_hat, green_turban)
            // eyewear: 총 2가지 (안입음, blue_sunglasses)
        }               
        answer -= 1; // 모두 안 입는 경우 1개 제거
        
        return answer;
    }
}
