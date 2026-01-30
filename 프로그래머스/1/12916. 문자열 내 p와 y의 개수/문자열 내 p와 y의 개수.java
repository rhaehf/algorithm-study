class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0;
        int ycnt = 0;
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p')
                pcnt++;
            else if (c == 'y')
                ycnt++;
        }

        if (pcnt != ycnt) answer = false;
        
        return answer;
    }
}
