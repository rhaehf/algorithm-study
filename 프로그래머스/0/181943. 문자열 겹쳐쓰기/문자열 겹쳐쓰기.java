class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        //answer = my_string.substring(0,s);        
        //answer = answer.concat(overwrite_string);
        //answer = answer.concat(my_string.substring(s+overwrite_string.length()));
        
        answer = my_string.substring(0,s).concat(overwrite_string) + my_string.substring(s+overwrite_string.length());
        return answer;
    }
}