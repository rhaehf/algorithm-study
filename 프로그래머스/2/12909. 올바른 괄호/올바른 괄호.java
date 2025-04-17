import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(')
                stack.push(1);
            else if(ch == ')' && !stack.isEmpty())
                stack.pop();
            else
                return false;
        }
        
        return stack.isEmpty();
    }
}