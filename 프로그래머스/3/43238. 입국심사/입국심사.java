import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);        
        long minTime = (long)times[0]; // 가능한 최소 시간 (가장 빠른 심사관이 1명 심사하는 시간)
        long maxTime = (long)times[times.length-1] * n; // 가능한 최대 시간 (가장 느린 심사관이 모든 사람을 다 심사하는 최악의 경우)
        
        while (minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2; // 이분 탐색의 중간 시간
            long pass = 0; // 입국심사를 통과한 인원

            // mid 시간 동안 처리 가능한 인원 계산
            for (int time : times) {
                pass += mid / time; // 해당 시간 내에 몇 명을 심사 가능한지 누적 계산
                if (pass >= n) 
                    break; // 통과 인원이 n명을 초과하면 더 계산할 필요 없음
            }

            if (pass >= n) { // 통과 가능한 인원이 통과를 기다리는 사람보다 많아지면
                answer = mid; // 가능한 시간 저장
                maxTime = mid - 1; // 더 작은 시간을 탐색하기 위해 최대 시간 범위를 줄임
            } else { // 통과 가능한 인원이 부족하므로
                minTime = mid + 1; // 시간 부족이기에 최소 시간 범위를 늘림
            }
        }

        return answer;
    }
}
