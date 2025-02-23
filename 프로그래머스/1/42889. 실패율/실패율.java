import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stopStage = new int[N+2]; // N+1 스테이지까지 기록해야함
        // 배열의 인덱스를 스테이지로 보고, 해당 스테이지에 멈춰있는 사람의 수가 값으로 담겨져 있다.
        for(int num : stages){
            stopStage[num]++;
        }        
        
        int people = stages.length; // 스테이지에 도달한 플레이어 수
        
        Map<Integer, Double> map = new HashMap<Integer, Double>(); // stage 번호, 실패율
        for(int i = 1; i < N+1; i++){
            int notClearPlayer = stopStage[i]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            
            // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
            if(notClearPlayer == 0){
                map.put(i, 0.0);
            } else{
                double percent = (double) notClearPlayer / people; // 실패율
                map.put(i, percent);
                //System.out.println("N : " + i + ", notClearPlayer : " + notClearPlayer + ", percent : " + percent);
                people -= notClearPlayer;
            }        
        }
        
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());

        // 실패율을 기준으로 내림차순 정렬
        entryList.sort((a, b) -> {
            if (b.getValue().compareTo(a.getValue()) == 0) {
                return a.getKey() - b.getKey(); // 실패율이 같다면 스테이지 번호 기준 오름차순 정렬
            }
            return b.getValue().compareTo(a.getValue()); // 실패율 기준 내림차순 정렬
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = entryList.get(i).getKey();
        }
        return answer;
    }
}