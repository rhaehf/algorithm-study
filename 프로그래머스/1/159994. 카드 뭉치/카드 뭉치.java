class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; // 카드 뭉치1 인덱스
        int idx2 = 0; // 카드 뭉치2 인덱스

        for (String word : goal) {
		        // 카드뭉치에서 목표 단어(word) 찾기
            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(word)) {
                idx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
