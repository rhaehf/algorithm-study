class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 시간들 초로 바꾸기
        int video = timeToSec(video_len);
        int now = timeToSec(pos);
        int start = timeToSec(op_start);
        int end = timeToSec(op_end);
        
        // 시작 위치가 오프닝 구간인지 확인
        now = skipOpening(now, start, end);
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                // 현재 위치가 10초 미만이면 영상 처음으로 이동
                // 아니면 현재 위치에서 10초 전으로 이동
                now = Math.max(0, now - 10);
            } 
            else { // next
                // 남은 시간이 10초 미만이면 영상 마지막으로 이동
                // 아니면 현재 위치에서 10초 후로 이동
                now = Math.min(video, now + 10);
            }
            
            // 이동할 때마다 오프닝 구간인지 확인
            now = skipOpening(now, start, end);
        }
        
        return String.format("%02d:%02d", now / 60, now % 60);
    }
    
    // 현재 재생 위치가 오프닝 사이에 있다면 오프닝 끝으로 이동 
    private int skipOpening(int now, int start, int end) {
        return (start <= now && now <= end) ? end : now;
    }
    
    // 시간 초로 변환
    private int timeToSec(String time) {
        int minute = Integer.parseInt(time.substring(0, 2));
        int sec = Integer.parseInt(time.substring(3, 5));
        return minute * 60 + sec;
    }
}
