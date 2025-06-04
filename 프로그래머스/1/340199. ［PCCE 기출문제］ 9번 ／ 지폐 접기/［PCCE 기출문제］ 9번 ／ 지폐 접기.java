class Solution {
    public int solution(int[] wallet, int[] bill) {        
        // 지갑과 지폐의 가로가 길다고 가정하고 문제를 풀었다.
        // 지갑의 가로, 세로 설정
        int walletW = Math.max(wallet[0], wallet[1]);
        int walletH = Math.min(wallet[0], wallet[1]);

        // 지폐의 가로, 세로 설정
        int billW = Math.max(bill[0], bill[1]);
        int billH = Math.min(bill[0], bill[1]);

        int foldCount = 0;

        while (true) {
            // 회전 포함한 넣기 가능 조건
            if ((billW <= walletW && billH <= walletH) ||
                (billH <= walletW && billW <= walletH)) {
                break;
            }

            if (billW >= billH) 
                billW /= 2;
            else 
                billH /= 2;

            foldCount++;

            // 더이상 접을 수 없을 때
            if (billW == 0 || billH == 0) return -1;
        }

        return foldCount;
    }
}
