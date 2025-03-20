class Solution {
    public String solution(String myString) {
        // 두번째 방법
        return myString.toLowerCase().replaceAll("a", "A");
        
        /*
        // 첫번째 방법
        String answer = "";
        
        for (char ch : myString.toLowerCase().toCharArray()) {
            if (ch == 'a')
                answer += 'A';
            else
                answer += ch;
        }
        return answer;
        */
    }
}