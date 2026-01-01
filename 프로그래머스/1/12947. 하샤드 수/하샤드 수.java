class Solution {
    public boolean solution(int x) {
        String num = String.valueOf(x);
        int sum = 0;
        
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }
        
        return x % sum == 0 ? true : false;
    }
}
