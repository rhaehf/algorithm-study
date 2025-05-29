import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 등장한 몸무게별 개수를 저장할 Map
        Map<Integer, Long> map = new HashMap<>();

        // 가능한 비율들 (분자, 분모)
        int[][] ratios = {
            {1, 1}, {2, 3}, {3, 2},
            {1, 2}, {2, 1}, {3, 4}, {4, 3}
        };

        for (int weight : weights) {
            // 이전에 등장했던 몸무게 중에서 짝꿍이 될 수 있는 것들을 찾음
            for (int[] ratio : ratios) {
                int numerator = ratio[0];
                int denominator = ratio[1];

                // 정수형 분수(비율)을 곱해 부동소수점 오차를 방지함 -> 나머지가 0인지를 통해 졍수인지 확인함
                // weight * numerator / denominator이 정수인지 확인
                if ((weight * numerator) % denominator != 0) continue;

                // weight × 거리1 == target × 거리2
                // target : 현재 몸무게로 만들 수 있는 균형 짝꿍 몸무게
                int target = (weight * numerator) / denominator;
                
                // weight가 짝꿍이 되려면 이미 등장한 몸무게 중 target이 있어야 함
                answer += map.getOrDefault(target, 0L);
            }

            // 현재 몸무게 등장 수 저장
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }

        return answer;
    }
}
