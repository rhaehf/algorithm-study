import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            // 1. 2진수 OR 연산 - 둘 중 하나라도 1이면 1로 변환
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            //System.out.println((arr1[i] | arr2[i]) + " = " + binary);
            
            // 2. 2진수 문자열을 n자리로 맞추기 (앞에 0으로 채움)
            // "%ns": 공백으로 앞을 채워서 전체 문자열을 n자리로 만들어줌
            binary = String.format("%" + n + "s", binary).replace(' ', '0');
            
            // 3. 암호 만들기
            String code = "";
            for (Character c : binary.toCharArray()) {
                code += (c == '1' ? "#" : " ");
            }
            //System.out.println(code);
            answer[i] = code;
        }
        
        return answer;
    }
}
