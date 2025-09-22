import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 기계의 열에 대한 스택 배열 생성
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++)
            lanes[i] = new Stack<>();
        
        // 역순으로 탐색하면서 기계의 인형을 스택에 추가
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0)
                    lanes[j].push(board[i][j]);
            }
        }
        
        int answer = 0; // 사라진 인형 세기
        Stack<Integer> stack = new Stack<>(); // 인형 담는 바구니
        
        for (int move : moves) {
            // 해당 열에 인형이 있으면
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pop();
                
                // 집어 올린 인형과 가장 위에 있는 인형이 같으면
                if (!stack.isEmpty() && doll == stack.peek()) {
                    stack.pop();
                    answer += 2;                        
                }
                // 인형이 같지 않으면 바구니에 넣기
                else
                    stack.push(doll);
            }
        }
        
        return answer;
    }
}
