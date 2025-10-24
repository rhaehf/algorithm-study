import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // list는 테스크케이스가 많으면 시간 초과가 발생해서 queue로 바꿈
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long total = sum1 + sum2;
        if (total % 2 != 0) return -1; // 불가능 케이스 ①: 전체 합이 홀수
        long target = total / 2;

        int count = 0;
        int limit = queue1.length * 3; // 최대 이동 횟수 (안정적 한계선)

        while (count <= limit) {
            if (sum1 == target) return count; // 정상 케이스 반환

            // 큐1이 크면 큐1에서 하나 빼서 큐2에 넣기
            if (sum1 > target) {
                int x = q1.poll();
                if (x == -1) return -1; // 안전 검사
                sum1 -= x;
                q2.add(x);
                sum2 += x;
            }
            // 큐2가 크면 큐2에서 하나 빼서 큐1에 넣기
            else {
                int x = q2.poll();
                if (x == -1) return -1;
                sum2 -= x;
                q1.add(x);
                sum1 += x;
            }

            count++;
        }

        // 불가능 케이스 ②: limit 초과
        return -1;
    }
}
