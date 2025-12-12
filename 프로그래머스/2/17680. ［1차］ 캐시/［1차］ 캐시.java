import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐시 크기가 0일 경우 
        if (cacheSize == 0)
            return 5 * cities.length;
        
        int answer = 0;
        List<String> caches = new LinkedList<>();
        
        for (String city : cities) {
             city = city.toLowerCase(); // 대소문자 구분을 하지 않음
            // cache miss
            if (!caches.contains(city)) {
                answer += 5;
                // 캐시를 담은 리스트의 사이즈가 캐시 크기만큼 커지면
                // 첫 번째 캐시가 가장 오래 사용하지 않은 것이므로 지우기
                if (caches.size() >= cacheSize) {
                    caches.remove(0);
                }
                caches.add(city);                
            }
            // cache hit
            else {
                caches.remove(city);
                caches.add(city);
                answer += 1;
            }
        }        
        
        return answer;
    }
}
