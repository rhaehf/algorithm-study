import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {       
        int[] gives = new int[friends.length]; // 받은 선물 기록
        int[] takes = new int[friends.length]; // 준 선물 기록
        int[][] records = new int[friends.length][friends.length]; // 주고, 받은 선물 기록
        
        List<String> names = Arrays.asList(friends);
        
        for (String gift : gifts) {
            String[] act = gift.split(" ");
            String give = act[0]; // 준 사람
            String take = act[1]; // 받은 사람
            
            gives[names.indexOf(give)] += 1;
            takes[names.indexOf(take)] += 1;      
            records[names.indexOf(give)][names.indexOf(take)] += 1;
        }
        //System.out.println(Arrays.deepToString(records));
        
        int[] acting = new int[friends.length]; // 선물 지수 계산 결과
        for (int i = 0; i < friends.length; i++) {
            acting[i] = gives[i] - takes[i]; // 선물지수 계산물지수 계산
        }
        
        int[] result = new int[friends.length]; // 다음달 받을 선물 개수
        // 쌍을 중복 없이 한 번씩 비교하기
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {  
                // 선물 주고받은 수가 같다면
                if (records[i][j] == records[j][i]) {
                    // 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물 하나 받기
                    if (acting[i] > acting[j]) result[i]++;
                    else if (acting[i] < acting[j]) result[j]++;
                } else {
                    if (records[i][j] > records[j][i]) result[i]++;
                    else result[j]++;
                }                
                
                /*
                // 선물 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
                if ((records[i][j] == 0 && records[j][i] == 0) || (records[i][j] == records[j][i])) {
                     if (acting[i] > acting[j])
                         result[i] += 1;
                    else if (acting[j] == acting[i])
                        continue;
                    else
                        result[j] += 1;                         
                }
                // 선물 주고받은 기록이 있다면
                else if (records[i][j] > 0 || records[j][i] > 0) {
                    if (records[i][j] > records[j][i])
                        result[i] += 1;
                    else
                        result[j] += 1;
                }
                */
            }
            //System.out.println(Arrays.toString(result));
        }
        //System.out.println(Arrays.toString(result));
        
        return Arrays.stream(result).max().getAsInt();
    }
}
