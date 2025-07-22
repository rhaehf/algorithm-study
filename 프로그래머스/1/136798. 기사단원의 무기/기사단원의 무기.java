class Solution {
    public int solution(int number, int limit, int power) {
        int iron = 0; // 필요한 철의 무게
        
        while (0 < number) {
            int count = 0; // 약수 개수 = 공격력
            
            // 약수 구하기
            for (int i = 1; i * i <= number; i++) {
                if (i * i == number) count++; // 약수가 1개 있음 (i)
                else if (number % i == 0) count += 2; // 약수가 2개 있음 (i랑 i로 나누었을 때 몫인 수)
            }
            
            if (limit < count) iron += power;
            else iron += count;
                
            number--;
        }
        
        return iron;
    }
}
