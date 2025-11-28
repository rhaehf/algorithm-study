import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicMinute = fees[0]; // 기본 시간(분)
        int basicFee = fees[1]; // 기본 요금(원)
        double extraMinute = fees[2]; // 단위 시간(분)	
        int extraFee = fees[3]; // 단위 요금(원)
        
        Map<String, Integer> carRecords = new HashMap<>(); // 차량 입차 기록 (차량 번호, 입차 시간(분단위))
        Map<String, Integer> parking = new HashMap<>(); // 차량별 총 주차시간 (차량 번호, 총 주차 시간)
        
        // 주차 시간 계산하기
        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0]; // 입차 또는 출차 시간
            int minutes = toMinutes(time); // 입출차 시간을 분으로 바꿈          
            String carNum = rec[1]; // 차량 번호
            String inOut = rec[2]; // 입차, 출차 여부
            
            if (inOut.equals("IN")) { // 입차하면 기록하기
                carRecords.put(carNum, minutes);
            } else { // 출차하면 주차 시간 계산하기
                int calculate = minutes - carRecords.get(carNum);
                parking.put(carNum, parking.getOrDefault(carNum, 0) + calculate);
                carRecords.remove(carNum);
            }                
        }
        
        // 출차 안한 차량의 주차 시간 계산
        if (!carRecords.isEmpty()) {
            for (String carNum : carRecords.keySet()) {
                int calculate = (23 * 60 + 59) - carRecords.get(carNum);
                parking.put(carNum, parking.getOrDefault(carNum, 0) + calculate);
            }
        }
        /*
        // 차량별 총 주차시간
        for (Map.Entry<String, Integer> entry : parking.entrySet()) {
            System.out.println(entry.getKey() + "(차번호) : " + entry.getValue());
        }
        */
        
        // 차량 번호 작은거부터 정렬하고, 주차 요금 계산해서 배열에 담아서 반환하기
        List<String> keySet = new ArrayList<>(parking.keySet());
        Collections.sort(keySet);
        
        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {    
            int parkingTime = parking.get(keySet.get(i));
            int overTime = parkingTime - basicMinute;
            
            if (overTime > 0 ) {
                answer[i] = (int) (basicFee + Math.ceil((double) overTime / extraMinute) * extraFee);
            } else { // 기본 시간 만큼 주차했다면
                answer[i] = basicFee;
            }
        }
        
        return answer;
    }
    
    // 시간을 분으로 바꾸기
    private static int toMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2)); // 들어오거나 나간 시각
        int minute = Integer.parseInt(time.substring(3)); // 들어오거나 나간 분
        return hour * 60 + minute;
    }
}
