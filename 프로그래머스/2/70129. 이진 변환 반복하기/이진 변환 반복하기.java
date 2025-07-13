class Solution {
    public int[] solution(String s) {
        int count = 0; // 제거 횟수
        int zero = 0; // 제거된 0의 개수
        
        while (1 < s.length()) {
            count++;
            int beforeLen = s.length(); // 0을 제거하기 전 길이
            s = s.replace("0", ""); // 모든 0 제거
            
            int len = s.length();
            zero += beforeLen - len; // 제거된 0 개수 더하기
            
            s = Integer.toString(len, 2); // 길이를 2진수로 바꾸기
            //System.out.println(count + "번째 : " + s);
        }
        
        //System.out.println(count + " / " + zero);
        return new int[] {count, zero};
    }
}
