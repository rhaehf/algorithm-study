class Solution {
    public String solution(int q, int r, String code) {
        // 두번째 방법 - r은 나머지, i에 몫만큼 더하기
        StringBuilder sb = new StringBuilder();

        for (int i = r; i < code.length(); i += q)
            sb.append(code.charAt(i));

        return sb.toString();        
        
        // 첫번째 방법
        /*
        String answer = "";
        
        for(int i = 0; i < code.length(); i++){
            if(i % q == r)
                answer += code.charAt(i);
        }        
        
        return answer;
        */
    }
}