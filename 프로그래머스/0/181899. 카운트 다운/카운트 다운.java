class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        
        int num = start_num;
        for(int i = 0; i <= start_num - end_num; i++)
            answer[i] = num--;
        return answer;
    }
}