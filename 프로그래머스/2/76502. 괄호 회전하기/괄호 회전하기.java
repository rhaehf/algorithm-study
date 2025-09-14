import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        // 괄호 정보를 저장함, 닫힌 괄호가 키임
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int answer = 0;
        int len = s.length();
        s += s; // 회전대신 같은 문자열을 이어붙임
        
        // s의 길이만큼 회전시키는 동안 확인
        A:for (int i = 0; i < len; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            // i부터 원본 문자열 길이까지 올바른 괄호인지 확인
            for (int j = i; j < i + len; j++) {
                char c = s.charAt(j);
                
                // 열린 괄호인 경우
                if (!map.containsKey(c))
                    stack.push(c); // 열린 괄호를 스택에 넣기
                else { // 닫힌 괄호인 경우
                    // 스택이 비어있거나 닫힌 괄호와 짝이 맞지 않은 경우
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A; // 내부 for문 조기 종료
                }
            }
            
            // 내부 for문을 모두 수행하고, 스택이 비어있으면 올바른 괄호 문자열임
            if (stack.isEmpty())
                answer++;
        }
        
        return answer;
    }
}
