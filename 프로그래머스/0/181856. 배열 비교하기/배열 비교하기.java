class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return Integer.compare(arr1.length, arr2.length);
        }

        int sum1 = 0, sum2 = 0;

        for (int num : arr1) {
            sum1 += num;
        }

        for (int num : arr2) {
            sum2 += num;
        }

        // 값이 같으면 0, 왼쪽 값이 크면 1, 오른쪽 값이 크면 -1을 반환
        return Integer.compare(sum1, sum2);
    }
}