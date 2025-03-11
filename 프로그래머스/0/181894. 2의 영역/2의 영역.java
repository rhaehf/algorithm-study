class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;

        // 첫 번째와 마지막 2의 인덱스 찾기
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) start = i; // 첫 번째 2
                end = i; // 가장 최근의 2
            }
        }
        
        // 2가 없는 경우
        if (start == -1) return new int[]{-1};

        int[] answer = new int[end - start + 1];
        System.arraycopy(arr, start, answer, 0, end - start + 1);

        return answer;
    }
}