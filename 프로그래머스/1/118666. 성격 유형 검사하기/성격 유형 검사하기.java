import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 성격 유형 점수를 저장할 Map
        Map<Character, Integer> map = new HashMap<>();
        for (char type : new char[] {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'}) {
            map.put(type, 0);
        }

        // 점수 계산
        for (int i = 0; i < survey.length; i++) {
            char type1 = survey[i].charAt(0); // 질문 타입
            char type2 = survey[i].charAt(1);
            int choice = choices[i]; // 선택지 점수

            // 모르겠음(choice 4번) 선택지를 선택하면 점수를 얻지 않는다.
            if (choice < 4) {
                map.put(type1, map.get(type1) + (4 - choice));
            } else if (choice > 4) {
                map.put(type2, map.get(type2) + (choice - 4));
            }
        }

        // 성격 유형 결과 조합
        StringBuilder result = new StringBuilder();
        char[][] indicators = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for (char[] pair : indicators) {
            char first = pair[0];
            char second = pair[1];
            if (map.get(first) < map.get(second)) {
                result.append(second);
            } else {
                result.append(first); // 점수가 같으면 사전 순으로 빠른 앞 순서 우선
            }
        }

        return result.toString();
    }
}
