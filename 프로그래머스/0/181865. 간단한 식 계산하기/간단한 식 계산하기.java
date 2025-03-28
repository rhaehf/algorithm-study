import java.util.*;

class Solution {
    public int solution(String binomial) {
        // 두번째 방법
        String[] parts = binomial.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char op = parts[1].charAt(0);

        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
        
        /*
        // 첫번째 방법 - StringTokenizer 사용하기
        if (binomial.contains("+")) {
            StringTokenizer st = new StringTokenizer(binomial, " + ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            return a + b;
        } else if (binomial.contains("-")) {
            StringTokenizer st = new StringTokenizer(binomial, " - ");
            int a = Integer.parseInt(st.nextToken().trim());
            int b = Integer.parseInt(st.nextToken().trim());
            return a - b;
        } else {
            StringTokenizer st = new StringTokenizer(binomial, " * ");
            int a = Integer.parseInt(st.nextToken().trim());
            int b = Integer.parseInt(st.nextToken().trim());
            return a * b;
        }
        */
    }
}