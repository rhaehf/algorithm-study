import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String num = Long.toString(n);
        String[] arr = new String[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = String.valueOf(num.charAt(i));
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}
