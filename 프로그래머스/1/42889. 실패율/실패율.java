import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stopStage = new int[N + 2]; // N+1 스테이지까지 기록해야함
        // 배열의 인덱스를 스테이지로 보고, 해당 스테이지에 멈춰있는 사람의 수가 값으로 담겨져 있다.
        for (int num : stages) {
            stopStage[num]++;
        }

        int people = stages.length; // 스테이지에 도달한 플레이어 수

        Map<Integer, Double> map = new HashMap<Integer, Double>(); // stage 번호, 실패율
        for (int i = 1; i < N + 1; i++) {
            int notClearPlayer = stopStage[i]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수

            if (notClearPlayer == 0) {
                // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
                map.put(i, 0.0);
            } else {
                double percent = (double) notClearPlayer / people; // 실패율
                map.put(i, percent);
                //System.out.println("N : " + i + ", notClearPlayer : " + notClearPlayer + ", percent : " + percent);
                people -= notClearPlayer;
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        // 실패율을 기준으로 내림차순 정렬
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        // 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}