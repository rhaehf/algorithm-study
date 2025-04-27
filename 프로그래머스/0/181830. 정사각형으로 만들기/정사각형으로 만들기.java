class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length; // 행 길이
        int column = arr[0].length; // 열 길이
        int max = Math.max(row, column);
        int[][] answer = new int[max][max];
        
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, arr[0].length);
        }
        /*
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        */
        return answer;
    }
}
