import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // (int[] 배열을 첫 번째 원소 = 작업의 요청 시점) 기준으로 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        // (int[] 배열을 두 번째 원소 = 작업의 소요시간) 기준으로 오름차순 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        int count = 0; // 수행된 요청 개수
        int jobsIdx = 0; // jobs 배열의 인덱스
        int end = 0; // 수행되고난 직후의 시간
        int sum = 0; // 반환 시간 총합      
		
        // 모든 요청이 수행될 때까지 반복
        while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]);
			}

			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0]; // 남아있는 요청의 "가장 빠른 요청 시점"으로 end를 맞춤
			} else { // 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행 
                int[] temp = pq.poll();
				sum += temp[1] + (end - temp[0]); // 작업 소요 시간 + 대기 시간=(작업이 끝난 시간 - 작업 요청 시점)
				end += temp[1]; // 현재 작업 끝나서 시간 갱신
				count++;                
			}
		}

		return (int) Math.floor(sum / jobs.length);        
    }
}
