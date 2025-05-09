// DFS 풀이
class Solution {  
    int count = 0;

    public int solution(int[] numbers, int target) {
        // 깊이, 숫자 배열, 목표 숫자, 현재 합계
        dfs(0, numbers, target, 0);
        return count;
    }

    private void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) { // 배열의 숫자를 모두 사용했을 때
            if (sum == target) { // 목표 숫자와 현재 함계가 같으면
                count++; // 케이스를 하나 찾은 것이다.
            }
            return;
        }
        // 재귀 호출 (백트래킹) -> 매번 +, - 로 나눠지면서 모든 조합을 탐색함
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}
