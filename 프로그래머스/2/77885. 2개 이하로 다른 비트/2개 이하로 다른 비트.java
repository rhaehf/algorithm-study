class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            
            // 짝수 : 마지막 비트만 0 → 1로 바뀌면 됨
            if (n % 2 == 0) { 
                answer[i] = n + 1;
            } 
            // 홀수 : 다른 비트 수가 2개 이하인 수를 만들어야 함
            else {
                // XOR 연산(^) 후 오른쪽 시프트 연산한 걸 더하면 2개 이하로 다른 비트를 구할 수 있다.
                long xor = n ^ (n + 1);
                answer[i] = n + (xor >> 2) + 1;
            }
        }

        return answer;
    }
}
