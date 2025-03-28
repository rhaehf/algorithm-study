import java.util.*;

class Solution {
    public int solution(String binomial) {
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
    }
}