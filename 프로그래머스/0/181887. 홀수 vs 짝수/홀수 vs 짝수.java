class Solution {
    public int solution(int[] num_list) {
        int odd = 0; // 홀수
        int even = 0; // 짝수
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) // 짝수
                even += num_list[i];
            else // 홀수
                odd += num_list[i];
        }
        
        return odd > even ? odd : even;
    }
}