class Solution { // 22 6 8
    public int solution(int n, int w, int num) {
        // 상자 번호(num)는 1부터 시작하지만, 인덱스 계산(row, col, aboveBox)은 0부터 시작하기 때문에 1을 빼서 계산함
        // 예시로 1을 빼지 않으면 num이 6일때 행과 열이 제대로 나오지 않음        
        
        int row = (num - 1) / w; // 꺼내려는 상자의 행
        // 짝수 행이면 열 방향 그대로(왼→오), 아니면 역방향
        int col = (row % 2 == 0) ? (num - 1) % w : (w - 1) - (num - 1) % w; // 꺼내려는 상자의 열
        
        // 정수 나눗셈에서 올림하려면 (n + w - 1) / w 공식을 사용함
        int totalRow = (n + w - 1) / w; // 상자의 전체 행 수
        
        int count = 0; // 꺼내야 하는 상자 개수
        
        // 꺼내려는 상자부터 위에 있는 상자의 인덱스 계산 (열 계산 아님, 상자 인덱스 0부터 시작함)
        for (; row < totalRow; row++) {
            // 짝수 행이면 인덱스 계산 정방향, 홀수 행이면 역방향
            int aboveBox = (row % 2 == 0) ? col + (row * w) : (w - 1 - col) + (row * w); // 위에 있는 박스의 인덱스
            
            // 전체 상자 개수 안에 있다면 증가
            if (aboveBox < n) count++;
        }

        return count;
    }
}
