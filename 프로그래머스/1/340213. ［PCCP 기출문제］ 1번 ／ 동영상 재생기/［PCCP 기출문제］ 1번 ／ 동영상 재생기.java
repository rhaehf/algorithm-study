class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 시간들 초로 바꾸기
        int video = timeToSec(video_len);
        int now = timeToSec(pos);
        int start = timeToSec(op_start);
        int end = timeToSec(op_end);
        
        // 시작 위치가 오프닝 구간인지 확인
        now = checkOpening(now, start, end);
        
        for (String order : commands) {
            // 10초 전으로 이동
            if (order.equals("prev")) {
                // 현재 위치가 10초 미만이면 영상 처음으로 이동
                if (now < 10) now = 0;
                else now -= 10;
            } 
            // 10초 후로 이동
            else {
                // 남은 시간이 10초 미만이면 영상 마지막으로 이동
                if ((video - now) < 10) now = video;
                else now += 10;
            }
            
            // 이동할 때마다 오프닝 구간인지 확인
            now = checkOpening(now, start, end);
        }
        
        return String.format("%02d:%02d", now / 60, now % 60);
    }
    
    // 현재 재생 위치가 오프닝 사이에 있다면 오프닝 끝으로 이동 
    private int checkOpening(int now, int start, int end) {
        if (start <= now && now <= end) {
            return end;
        }
        return now;
    }
    
    // 시간 초로 변환
    private int timeToSec(String time) {
        int minute = Integer.parseInt(time.substring(0, 2));
        int sec = Integer.parseInt(time.substring(3, 5));
        return minute * 60 + sec;
    }
}
