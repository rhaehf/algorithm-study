import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> dict = new HashMap<>(); // (단어, 색인 번호)
        int nextIndex = 1; // 색인 번호

        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), nextIndex++);
        }

        
        for (int i = 0; i < msg.length();) {
            int idx = 1;
            
            // 현재 입력의 길이를 한 글자씩 증가하면서 글자 찾기
             while ((i + idx) <= msg.length() && dict.containsKey(msg.substring(i, i + idx))) {
                 idx++;
             }
            
            // idx는 "사전에 없는" 길이까지 1 더 커진 상태이므로, 실제 w는 idx-1
            String w = msg.substring(i, i + (idx - 1)); // 현재 입력
            answer.add(dict.get(w)); // 현재 입력의 색인 번호 담기
            
            // 다음 글자 포함(w+c)이 가능한 경우에만 사전에 추가
            if (i + idx <= msg.length()) {
                String wc = msg.substring(i, i + idx); // 현재 입력 + 다음 글자
                dict.put(wc, nextIndex++); // 사전 추가(w+c, 색인 번호)
            }
            
            // w 길이만큼 점프하려고 직접 i를 조정함
            i += w.length();
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
