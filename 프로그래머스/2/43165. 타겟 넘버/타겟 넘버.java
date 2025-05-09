// DFS 풀이 2 -> 리턴값 누적 방식
class Solution {    
    public int solution(int[] numbers, int target) {
        // 깊이, 숫자 배열, 목표 숫자, 현재 합계
        return dfs(0, numbers, target, 0); // 재귀 함수 호출
    }

    private int dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) { // 배열의 모든 숫자를 사용했을 때
            if (sum == target) { // 목표 숫자와 현재 합계가 같으면
                return 1; // 유효한 조합이므로 1가지 방법을 찾아서 1을 반환
            }
            return 0; // 합계가 맞지 않으면 실패한 경로이므로 0을 반환
        }
        // 모든 경로에서 성공한 경우를 1씩 반환하고, 재귀적으로 + 연산하여 총 합을 리턴
        return dfs(depth + 1, numbers, target, sum + numbers[depth])
             + dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}

// DFS 풀이 1 -> 전역 변수 방식
/*
class Solution {  
    int count = 0;

    public int solution(int[] numbers, int target) {
        // 깊이, 숫자 배열, 목표 숫자, 현재 합계
        dfs(0, numbers, target, 0);
        return count;
    }

    private void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) { // 배열의 모든 숫자를 사용했을 때
            if (sum == target) { // 목표 숫자와 현재 합계가 같으면
                count++; // 유효한 조합이므로 1가지 방법을 찾았다.
            }
            return;
        }
        // 재귀 호출 (백트래킹) -> 매번 +, - 로 나눠지면서 모든 조합을 탐색함
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}
*/
