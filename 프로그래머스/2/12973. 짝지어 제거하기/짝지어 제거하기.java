// 스택 풀이

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                // 이전 문자와 같으면 스택에 저장된 같은 문자 제거
                stack.pop();
            } else {
                // 아니면 넣기
                stack.push(ch);
            }
        }

        // 스택이 비었으면 모든 문자가 제거된 상태
        return stack.isEmpty() ? 1 : 0;
    }
}
