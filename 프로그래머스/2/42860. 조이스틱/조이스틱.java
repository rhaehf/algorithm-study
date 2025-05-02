class Solution {
    public int solution(String name) {
        int upDown = 0;
        int length = name.length();

        // 1. 상하 이동(각 알파벳 변경 횟수)
        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            // min(A에서부터 변경, Z에서부터 변경) - 알파벳은 A에서 시작하기 때문에 A에서 Z로 역순 이동하는 1번을 더해준다.
            upDown += Math.min(ch - 'A', 'Z' - ch + 1); 
        }

        // 2. 좌우 이동 최소값 탐색
        int minMove = length - 1; // 기본은 오른쪽 끝까지 이동

        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // 연속된 A 구간의 끝을 찾음
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 탐색 방법 1 : 오른쪽으로 갔다가 왼쪽으로 돌아오는 경우
            int move = i * 2 + length - next;

            // 탐색 방법 2 : 또는 왼쪽으로 갔다가 오른쪽으로 도는 경우
            int reverseMove = (length - next) * 2 + i;

            // 그 중 최소값 선택
            minMove = Math.min(minMove, Math.min(move, reverseMove));
        }

        return upDown + minMove;
    }
}
