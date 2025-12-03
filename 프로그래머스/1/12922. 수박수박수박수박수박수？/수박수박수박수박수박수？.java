class Solution {
    public String solution(int n) {
        String first = "수";
        String second = "박";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                sb.append(first);
            else
                sb.append(second);
        }
        return sb.toString();
    }
}
