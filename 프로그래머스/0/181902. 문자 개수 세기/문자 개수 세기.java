class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(char c : my_string.toCharArray()){
            int index = 0;
            if (Character.isUpperCase(c)) {
                // 대문자일 때 인덱스
                index = c - 65;                
            } else {
                // 소문자일 때 인덱스
                index = c - 71;
            }
            answer[index]++;             
        }
        
        return answer;
    }
}
