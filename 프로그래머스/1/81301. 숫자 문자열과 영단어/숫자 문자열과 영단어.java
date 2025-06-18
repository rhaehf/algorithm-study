class Solution {
    public int solution(String s) {
        String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for (int i = 0; i < 10; i++) {
            if (s.contains(alpha[i])) {
                s = s.replace(alpha[i], num[i]);
                //System.out.println(s);
            }            
        }

        return Integer.parseInt(s);
    }
}
