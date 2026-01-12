class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; sb.length() < t * m; i++) {
            String trans = Integer.toString(i, n).toUpperCase();
            sb.append(trans);
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int idx = (p - 1) + i * m;
            answer.append(sb.charAt(idx));
        }
        
        return answer.toString();
    }
}
