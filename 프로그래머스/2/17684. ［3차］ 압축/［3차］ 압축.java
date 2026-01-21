import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        dict.add(""); // index 0번은 더미 처리

        for (char c = 'A'; c <= 'Z'; c++) {
            dict.add(String.valueOf(c));
        }
        
        for (int i = 0; i < msg.length();) {
            int idx = 1;
            
            // 현재 입력의 길이를 한 글자씩 증가하면서 글자 찾기
             while ((i + idx) <= msg.length() && dict.contains(msg.substring(i, i + idx))) {
                 idx++;
             }
            
            // len은 "사전에 없는" 길이까지 1 더 커진 상태이므로, 실제 w는 idx-1
            String w = msg.substring(i, i + (idx - 1));
            answer.add(dict.indexOf(w)); // 현재 입력의 색인 번호 담기
            
            // 다음 글자 포함(w+c)이 가능한 경우에만 사전에 추가
            if (i + idx <= msg.length()) {
                String wc = msg.substring(i, i + idx);
                dict.add(wc);
            }
            
            // w 길이만큼 점프하려고 직접 i를 조정함
            i += w.length();
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
