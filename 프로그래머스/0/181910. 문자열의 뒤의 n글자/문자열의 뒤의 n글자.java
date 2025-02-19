class Solution {
    public String solution(String my_string, int n) {
        // 두번째 풀이
        String answer = my_string.substring(my_string.length() - n);
        
        // 첫번째 풀이
        /*
        int len = my_string.length();
        String answer = my_string.substring(len-n, len);
        */
        return answer;
    }
}