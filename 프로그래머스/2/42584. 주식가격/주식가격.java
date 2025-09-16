import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;        
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>(); // prices의 인덱스 저장
        stack.push(0); // 비교대상이 없으므로 초깃값 0 넣기
        
        // 스택에는 현재 주식과 비교해서 가격이 떨어지지 않은 이전 주식만 남겨둠
        for (int i = 1; i < n; i++) { 
            // 현재 주식이 이전 주식보다 가격이 떨어졌으면 
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop(); // 이전 주식의 인덱스 제거
                answer[j] = i - j; // 가격이 떨어지지 않은 기간 계산
            }
            
            // 현재 주식이 이전 주식보다 가격이 안떨어지면 스택에 넣기
            // 기간이 확정되지 않은 주식의 인덱스를 스택에 넣음            
            stack.push(i); 
        }
        
        // 가격이 끝까지 떨어지지 않은 인덱스가 남아있음
        // 남아있는 인덱스의 기간을 한번에 구함
        while (!stack.isEmpty()) {
          int j = stack.pop();
          answer[j] = n - 1 - j;
        }
        
        return answer;
    }
}
