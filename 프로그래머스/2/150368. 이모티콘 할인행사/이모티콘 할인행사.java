class Solution {
    static int EMOTICON_PLUS; // 총 이모티콘 플러스 서비스 가입자수
    static int TOTAL_SALES; // 총 이모티콘 구매 비용
    static final int[] SALE_RATE = {10, 20, 30, 40}; // 이모티콘 할인율
    
    public int[] solution(int[][] users, int[] emoticons) {
        EMOTICON_PLUS = 0; // 매 테스트 케이스 호출마다 초기화
        TOTAL_SALES = 0;
        
        setRateRecur(users, emoticons, 0, new int[emoticons.length]);
        return new int[] {EMOTICON_PLUS, TOTAL_SALES};
    }
    
    // 재귀 기반 DFS 방식으로 완전 탐색을 수행해 이모티콘 할인율 조합 생성
    private void setRateRecur(int[][] users, int[] emoticons, int index, int[] rates) {
        // index: 몇 번째 이모티콘에 접근했는지, rates: saleRate 중 이모티콘에 적용할 할인율 담는 배열
        
        // 제일 마지막 이모티콘까지 재귀 호출되었다면, 최적의 할인율 조합인지 확인
        if (index == emoticons.length) {
            findComb(users, emoticons, rates);
            return;
        }
        
        for (int rate : SALE_RATE) {
            rates[index] = rate;
            // 다음 이모티콘의 할인율을 정하러 재귀함수 사용
            setRateRecur(users, emoticons, index + 1, rates);
        }
    }
    
    // 최적의 이모티콘 할인율 조합인지 확인
    private void findComb(int[][] users, int[] emoticons, int[] rates) {
        int emoticonPlus = 0; // 현재 할인율 조합의 이모티콘 플러스 가입자수
        int totalSales = 0; // 현재 할인율 조합의 이모티콘 구매 비용
        
        for (int[] user : users) {
            int purchase = 0; // 이모티콘 구매 비용
            int rate = user[0]; // 해당 할인율 이상이어야 사용자가 이모티콘을 구매함
            int maxPurchase = user[1]; // 사용자가 지불 가능한 최대 이모티콘 구매 비용
            
            for (int i = 0; i < rates.length; i++) {
                // 이모티콘 할인율이 더 크다면 이모티콘을 구매함
                if (rate <= rates[i]) {
                    purchase += (emoticons[i] * (100 - rates[i]) / 100);
                }
            }
            
            // 최대 이모티콘 구매 비용 이상이 되면 이모티콘 플러스 가입 
            if (maxPurchase <= purchase) emoticonPlus++;
            // 아니면 이모티콘 구매 비용 업데이트
            else totalSales += purchase;
        }
        
        // 현재 할인율 조합의 이모티콘 플러스 가입자수가 많다면 총 결과 업데이트
        if (EMOTICON_PLUS < emoticonPlus) {
            EMOTICON_PLUS = emoticonPlus;
            TOTAL_SALES = totalSales;
        }
        // 이모티콘 플러스 가입자수가 같으면 더 큰 이모티콘 구매 비용으로 업데이트
        else if (EMOTICON_PLUS == emoticonPlus) {
            TOTAL_SALES = Math.max(totalSales, TOTAL_SALES);
        }
    }
}
