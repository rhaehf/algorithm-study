class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0; // 페인트칠 횟수
        int check = 0; // 페인트를 어디까지 칠했는지 위치 체크
        
        for (int sec : section) {
            // 지금까지 칠한 곳보다 다음 칠해야 할 구역이 크다면
            if (check < sec) {
                count++; // 페인트 칠하고
                check = sec + m - 1; // 칠한 위치 갱신
            }
        }
        
        return count;
    }
}
