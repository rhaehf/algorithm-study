import java.util.*;

class Solution {
    public long solution(long n) {
        String num = Long.toString(n); // 문자로 변환
        int[] arr = new int[num.length()]; // 숫자 하나씩 담을 배열
        
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
