import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String trans = Integer.toString(n, k); // k진수로 변환
        String[] parts = trans.split("0+"); // 연속된 0 기준 분리 (빈 문자열 방지)
        //System.out.println(Arrays.toString(parts));
        
        int answer = 0;
        for (String p : parts) {
            long num = Long.parseLong(p);
            if(num == 1) continue; // 1은 소수가 될 수 없음
            if (isPrime(num)) answer++; // 소수인지 판별
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num % 2 == 0) return num == 2; // 짝수 소수가 안되는데 2는 가능함
        
        long root = (long)Math.sqrt(num); // √x까지만 검사해도 충분함
        for (long i = 3; i <= root; i += 2) { // 짝수는 걸러냈기 때문에 2씩 증가시킴
            if (num % i == 0) return false;
        }
        return true; // 어떤 수로도 나누어지지 않으면 소수
    }
}
