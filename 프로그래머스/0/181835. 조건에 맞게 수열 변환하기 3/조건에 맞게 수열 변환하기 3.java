class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        int idx = 0;
        
        if (k % 2 == 0) { // k가 짝수
            for (int num : arr)
                answer[idx++] = num + k;            
        } else { // k가 홀수
            for (int num : arr)
                answer[idx++] = num * k;      
        }
        
        return answer;
    }
}