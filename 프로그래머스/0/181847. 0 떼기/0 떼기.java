class Solution {
    public String solution(String n_str) {
        String answer = "";
        
        for(char ch : n_str.toCharArray()){
            if(ch != '0')
                answer += ch;
            else if(ch == '0' && answer.length() >= 1)
                answer += ch;            
        }
        return answer;
    }
}