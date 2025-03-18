class Solution {
    public int solution(String myString, String pat) {
        if(pat.length() > myString.length())
            return 0;

        // 두번재 방법 : indexOf - 찾는 문자열이 없으면 -1을 반환, 있으면 문자열 앞에서부터 처음 발견되는 인덱스를 반환
        int answer = myString.toLowerCase().indexOf(pat.toLowerCase()) != -1 ? 1 : 0;
        
        // 첫번째 방법
        //int answer = myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
        
        return answer;
    }
}