import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][]; // 더한 값을 담을 2차원 배열
        
        // dp 배열 생성
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }        
        
        // 삼각형의 가장 꼭대기 값
        dp[0][0] = triangle[0][0];
        
        // 점화식
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) {
                    // 가장 왼쪽 값 구하기 : 오른쪽 위에 값 가져오기
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    // 가장 오른쪽 값 구하기 : 왼쪽 위에 값 가져오기
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    // 중간 값 구하기
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp)); // 2차원 배열 출력
        
        // 마지막 배열만 추출
        int[] lastArr = Arrays.copyOfRange(dp[dp.length-1], 0, dp[dp.length-1].length);
        // 오름차순 정렬
        Arrays.sort(lastArr);
        // 마지막 인덱스 값 출력
        return lastArr[lastArr.length-1];
    }
}
