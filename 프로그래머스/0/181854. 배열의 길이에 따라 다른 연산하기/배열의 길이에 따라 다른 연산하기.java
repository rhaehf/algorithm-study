class Solution {
    public int[] solution(int[] arr, int n) {
        if (arr.length % 2 != 0) { // 홀수
            for (int i = 0; i < arr.length; i += 2) {
                arr[i] += n;
            }
        } else { // 쨕수
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] += n;
            }
        }
        return arr;
    }
}