import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 해시맵에 key는 선수 이름, value는 선수의 수를 입력
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);    
        }
        
        // 참가자 명단을 확인하며 같은 선수 이름이 있는지 확인
        for (String name : participant) {
            // 완주하지 못한 사람의 이름이거나 동명이인이 이미 들어왔다면 0을 반환함
            int count = map.getOrDefault(name, 0);
            
            // 0이면 완주를 못한것이기 때문에 이름 반환
            if (count == 0) return name;
            
            // 해당 이름의 선수의 수 1 차감
            map.put(name, count - 1);            
        }
        
        return null;
    }
}
