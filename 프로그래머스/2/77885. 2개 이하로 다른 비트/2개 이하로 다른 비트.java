class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) { 
            long big = numbers[i]++;
            // XOR 연산(^) 후 오른쪽 시프트 연산한 걸 기존 수에 더하면 n개 이하로 다른 비트를 구할 수 있다.
            long result = numbers[i] + ((numbers[i] ^ big) >> 2);
            answer[i] = result;
        }        
        
        return answer;
    }
}
