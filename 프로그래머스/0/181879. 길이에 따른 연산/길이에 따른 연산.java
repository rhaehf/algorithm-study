class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if(num_list.length >= 11){
            for(int num : num_list)
                answer += num;
        } else {
            if(answer == 0)
                answer = 1;
            
            for(int num : num_list)
                answer *= num;
        }
        
        return answer;
    }
}