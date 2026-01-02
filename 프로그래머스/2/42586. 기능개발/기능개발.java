import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;
        
        int[] leftWork = new int[n]; // 배포까지 남은 작업일
        for (int i = 0; i < n; i++) {
            // 올림해서 작업일 구하기
            leftWork[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); // 정수형끼리 나누면 소수점 사라짐
        }
        
        int count = 0; // 각 배포일에 배포할 기능 개수
        int maxDay = leftWork[0]; // 남은 작업중 가장 늦게 배포될 작업일
        
        for (int i = 0; i < n; i++) {
            // 배포일이 가장 늦은 배포 가능일보다 빠르면
            if (leftWork[i] <= maxDay) {
                count++; // 같이 배포하기 위해 기능 개수 추가
            } else {
                answer.add(count); // 배포함
                count = 1;
                maxDay = leftWork[i];
            }
        }
        
        answer.add(count); // 남은 작업개수 배포함
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
