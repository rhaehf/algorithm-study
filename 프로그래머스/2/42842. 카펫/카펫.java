class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int yellowSize = (brown - 4) / 2; // 노란 카펫의 가로 + 세로 길이
        
        // 노란 카펫의 크기 구하기
        for (int i = 1; i <= (yellowSize / 2); i++) {
            // i = 노란 카펫의 세로 길이, yellowSize - i = 노란 카펫의 가로 길이
            if (i * (yellowSize - i) == yellow) {
                // 2를 더하는 이유는 카펫의 네 모서리 값을 더한것임
                answer = new int[] {yellowSize - i + 2, i + 2};
                break;
            }
        }        
        
        return answer;
    }
}