class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idxA = 0; // answer의 인덱스
        
        for (String p : picture) {
            // 가로로 k배 늘리기
            String line = "";
            for (char ch : p.toCharArray()) {
                int idx = k;
                while (0 < idx--) {
                    line += ch;
                }
            }
            //System.out.println(line);
            
            // 세로로 k배 늘리기
            int index = k;
            while (0 < index--) {
                answer[idxA++] = line;
            }
        }
        return answer;
    }
}
