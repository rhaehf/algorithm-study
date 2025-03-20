class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (char ch : myString.toLowerCase().toCharArray()) {
            if (ch == 'a')
                answer += 'A';
            else
                answer += ch;
        }
        return answer;
    }
}