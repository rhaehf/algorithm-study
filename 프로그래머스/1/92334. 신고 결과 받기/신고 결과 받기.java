import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // (신고당한 사람, 신고한 사람들)
        Map<String, Set<String>> reportedBy = new HashMap<>(); 
        
        // 1. 신고 데이터를 정리해서 map에 담는다.
        for (String ids : report) {
            String[] id = ids.split(" ");
            String reporter = id[0]; // 신고한 사람
            String reportedUser = id[1]; // 신고당한 사람
            reportedBy.computeIfAbsent(reportedUser, i -> new HashSet<>()).add(reporter);
        }
        
        // 2. k이상 신고된 정지 대상자 리스트를 만든다.
        List<String> bannedUsers = new ArrayList<>(); // 정지 대상자 리스트
        for (Map.Entry<String, Set<String>> entry : reportedBy.entrySet()) {
            if (entry.getValue().size() >= k) // 신고 당한 횟수가 k 이상이면
                bannedUsers.add(entry.getKey()); // 신고 당한 사람 이름을 리스트에 담는다.
        }
        
        // id_list의 순서를 담은 인덱스 맵을 만든다.
        Map<String, Integer> idx = new HashMap<>(); // (이름, 배열 인덱스 번호)
        for (int i = 0; i < id_list.length; i++) idx.put(id_list[i], i);

        // 3. 정지 대상자를 신고한 사람들 이름에 해당하는 인덱스로 받아야하는 메일을 카운트한다. 
        int[] mailCounts = new int[id_list.length];
        for (String banned : bannedUsers) {
            for (String name : reportedBy.get(banned)) {
                mailCounts[idx.get(name)]++;
            }                
        }
        
        return mailCounts;
    }
}
