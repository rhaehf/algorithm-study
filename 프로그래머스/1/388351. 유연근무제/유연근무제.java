class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int people = schedules.length; // 전체 직원 수
        
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100; // 출근 인정 시각의 시
            int minute = schedules[i] % 100 + 10; // 출근 인정 시각의 분
            
            // 출근 인정 시간 계산
            if (minute >= 60) {
                minute -= 60; // 60분 초과 분만 남기고
                hour++; // 1시간 추가
            }            
            int limit = hour * 100 + minute; // 출근 인정 시각
            
            int day = startday; // 출근 요일
            boolean late = false; // 지각 체크
            
            // 일주일 출근 시간 확인하기
            for (int time : timelogs[i]) { 
                // 토요일이거나 일요일이면 넘기기
                if (day % 7 == 6 || day % 7 == 0) {
                    day++;
                    continue;
                }
                
                // 늦지않고 출근했으면 다음낳 출근 시간 확인하기
                if (time <= limit) day++;
                // 지각했으면 지각 체크
                else {
                    late = true;
                    break;
                }
            }
            
            // 지각했으면 상품 받을 직원 수 차감
            if (late) people--;
        }
        
        return people;
    }
}
