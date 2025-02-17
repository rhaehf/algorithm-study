class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] array = my_string.toCharArray();
        
        // int[세로][가로] = int[4][2]
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            
            // start 부터 end까지 뒤집기
            while (start < end) {
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        
        return String.valueOf(array);
    }
}