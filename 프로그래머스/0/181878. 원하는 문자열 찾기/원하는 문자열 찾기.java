class Solution {
    public int solution(String myString, String pat) {
        if(pat.length() > myString.length())
            return 0;

        int answer = myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
        return answer;
    }
}