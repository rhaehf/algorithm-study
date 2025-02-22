class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string.substring(0,s);
        
        char[] array = my_string.substring(s,e+1).toCharArray();
        for(int i = array.length - 1; 0 <= i ; i--){
            answer += array[i];
        }
        
        return answer + my_string.substring(e+1);
    }
}