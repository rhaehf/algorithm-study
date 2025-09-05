class Solution {
    public int[] solution(long n) {
        String num = Long.toString(n);        
        int[] answer = new int[num.length()];
        
        int idx = 0;
        for (int i = num.length() - 1; 0 <= i; i--)
            answer[idx++] = num.charAt(i) - '0';
        
        return answer;
    }
}