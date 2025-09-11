import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        initLocation(); // 이동 명령어 세팅
        
        int x = 5, y = 5; // 음수 이동 때문에 (0,0)에서 (5,5)로 시작 위치를 바꿈 
        
        // 이동한 기록 저장하는 곳 (중복 저장 안됨)
        HashSet<String> answer = new HashSet<>();    
        
        for (char ch : dirs.toCharArray()) {
            int[] offset = location.get(ch);
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            // 좌표평면 범위 벗어나면 넘어가도록
            if (!isValidMove(nx, ny)) continue;
            
            // A에서 B이든, B에서 A든 같은 경로로 취급해서 양방향 다 추가하고, 길이는 나누기 2 해줌
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            // 이동한 좌표로 업데이트
            x = nx;
            y = ny;
        }
        
        return answer.size() / 2;
    }
    
    private static final HashMap<Character, int[]> location = new HashMap<>();
    // 명령어 이동방향 4가지 세팅
    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }
    
    // 좌표평면을 벗어나는지 확인
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx <= 10 && 0 <= ny && ny <= 10;
    }
}
