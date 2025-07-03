import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("R", 0); // 라이언형
        map.put("T", 0); // 튜브형
        map.put("C", 0); // 콘형
        map.put("F", 0); // 프로도형
        map.put("J", 0); // 제이지형
        map.put("M", 0); // 무지형
        map.put("A", 0); // 어피치형
        map.put("N", 0); // 네오형
        
        for (int i = 0; i < survey.length; i++) {            
            String type1 = String.valueOf(survey[i].charAt(0)); // 질문 타입
            String type2 = String.valueOf(survey[i].charAt(1));
            int choice = choices[i]; // 선택지 점수
            
            // 모르겠음 선택지를 선택하면 점수를 얻지 않는다.
            if (choice == 4) continue;
            
            if (choice <= 3) {
                map.put(type1, map.getOrDefault(type1, 0) + (4 - choice));                          
            } else if (5 <= choice) {
                map.put(type2, map.getOrDefault(type2, 0) + (choice - 4));                
            }
        }
        
        /*for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }*/
        
        StringBuilder sb = new StringBuilder();
        
        // 1번 지표
        if (map.get("R") < map.get("T"))
            sb.append("T");
        else
            sb.append("R");
        
        // 2번 지표
        if (map.get("C") < map.get("F"))
            sb.append("F");
        else
            sb.append("C");
        
        // 3번 지표
        if (map.get("J") < map.get("M"))
            sb.append("M");
        else
            sb.append("J");
        
        // 4번 지표
        if (map.get("A") < map.get("N"))
            sb.append("N");
        else
            sb.append("A");
        
        return sb.toString();
    }
}