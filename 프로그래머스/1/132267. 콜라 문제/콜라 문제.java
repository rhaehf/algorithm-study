class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0; // 교환 받은 콜라 수

        while (n >= a) {
            int exchanged = n / a * b; // 빈 병 a개 주고 교환받은 콜라 수
            answer += exchanged;

            int remain = n % a; // 교환하고 남은 빈 병
            
            // 다시 사용할 수 있는 빈 병 수 갱신
            n = remain + exchanged; // 남은 병 + 새로 마신 콜라에서 생긴 빈 병            
        }

        return answer;
    }
}
