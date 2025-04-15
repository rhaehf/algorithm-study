class Solution {
    public String solution(String n_str) {
        // 두번째 방법 - 숫자로 변환하면서 앞에 0은 날라감
        return "" + Integer.parseInt(n_str);
        
        /*
        // 첫번째 방법
        String answer = "";
        
        for(char ch : n_str.toCharArray()){
            if(ch != '0')
                answer += ch;
            else if(ch == '0' && answer.length() >= 1)
                answer += ch;            
        }
        return answer;
        */
    }
}