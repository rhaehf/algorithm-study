class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지갑과 지폐의 가로가 길다고 가정하고 문제를 풀었다.
        // 지갑의 가로, 세로 설정
        int walletW = Math.max(wallet[0], wallet[1]);
        int walletH = Math.min(wallet[0], wallet[1]);

        // 지폐의 가로, 세로 설정
        int billW = Math.max(bill[0], bill[1]);
        int billH = Math.min(bill[0], bill[1]);

        while (walletH < billH || walletW < billW) {
            // 지폐의 긴 쪽을 반 접기
            if (billH < billW)
                billW = billW / 2;
            else
                billH = billH / 2;

            answer++;

            if (Math.max(billW, billH) <= walletW && Math.min(billW, billH) <= walletH)
                break;
        }
        
        return answer;
    }
}
