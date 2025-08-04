class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; // 카드 뭉치1 인덱스
        int idx2 = 0; // 카드 뭉치2 인덱스
        
        for (String word : goal) {
            boolean flag = false; // 목표 단어가 있는지
            
            // 카드뭉치에서 목표 단어(word) 찾기
            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
                flag = true;
                idx1++;
            }                
            else if (idx2 < cards2.length && cards2[idx2].equals(word)) {
                flag = true;
                idx2++;
            }
            
            // 목표 단어를 찾지 못하면 바로 "No" 리턴
            if (!flag)
                return "No";         
        }

        return "Yes";
    }
}
