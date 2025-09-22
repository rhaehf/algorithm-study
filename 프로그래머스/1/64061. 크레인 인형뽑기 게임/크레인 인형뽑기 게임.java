import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length; // 격자 크기
        Stack<Integer> stack = new Stack<>(); // 인형 담는 바구니
        
        for (int move : moves) {
            int y = move - 1;
            
            for (int row = 0; row < size; row++) {
                int pick = board[row][y];
                if (pick != 0) {
                    // 집어 올린 인형과 이전에 있던 인형이 같으면
                    if (!stack.isEmpty() && pick == stack.peek()) {
                        stack.pop();
                        answer += 2;                        
                    }
                    // 인형이 같지 않으면 바구니에 넣기
                    else
                        stack.push(pick);
                    
                    //System.out.println(move + " : " + row + ", " + y + " - " + stack);                     
                    board[row][y] = 0; // 집어 올린 인형 자리는 빈 상태로 바꾸기
                    break; // 인형을 집었으니까 다음 move로 넘어가기
                }
            }
        }
        
        return answer;
    }
}
