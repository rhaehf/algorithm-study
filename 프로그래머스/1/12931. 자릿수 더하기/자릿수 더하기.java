import java.util.*;

public class Solution {
    public int solution(int n) {
        //String num = String.valueOf(n);
        String num = Integer.toString(n);
        
        int answer = 0;
        for (char ch : num.toCharArray())
            answer += (ch - '0');

        return answer;
    }
}
