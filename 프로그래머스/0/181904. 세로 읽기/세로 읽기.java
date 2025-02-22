class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        // m은 my_string의 약수이기에 나누어서 줄의 개수를 구함
        int line = my_string.length() / m;
        for(int i = 0; i < line; i++){
            answer += my_string.charAt(i*m + c -1);
        }
        return answer;
    }
}