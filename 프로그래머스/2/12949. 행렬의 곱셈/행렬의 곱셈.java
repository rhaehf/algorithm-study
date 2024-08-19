class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬 arr1과 arr2의 행과 열의 수
        int r1 = arr1.length; // 행
        int c1 = arr1[0].length; // 열
        int r2 = arr2.length; // 행
        int c2 = arr2[0].length; // 열

        // 결과는 행렬의 크기만큼 사이즈 만들기
        int[][] answer = new int[r1][c2];

        // arr1의 각 행과 arr2의 각 열에 대해
        for (int i = 0; i < r1; i++) { // r1 = arr1.length
            for (int j = 0; j < c2; j++) { //  c2 = arr2[0].length
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}