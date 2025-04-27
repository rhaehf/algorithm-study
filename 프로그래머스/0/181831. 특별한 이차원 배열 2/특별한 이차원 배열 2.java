class Solution {
    public int solution(int[][] arr) {   
        // 두번째 방법 - 삼각형 절반(상삼각형)만 확인함
        // 상삼각형 : 2차원 배열에서 행 번호 ≤ 열 번호(i ≤ j)인 위치만을 보는 것
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // j = i+1부터 검사
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        // 여전히 O(N²)지만 이전과 비교해서 검사 횟수가 절반이다.
        return 1;
        
        /*
        // 첫번째 방법 - 전체 대칭 행렬 검사
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == arr[j][i])
                    continue;
                else
                    return 0;
            }
        }
        return 1;
        */
    }
}
