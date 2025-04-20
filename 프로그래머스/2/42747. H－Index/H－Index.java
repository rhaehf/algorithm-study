import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // int형 내림차순 정렬은 Integer로 가능해서 형변환 해야함
        Integer[] desc = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(desc, Collections.reverseOrder());
        int maxUse = desc[0]; // 가장 많이 인용된 논문 수

        while (0 <= maxUse) {
            int count = 0; // 인용된 눈문 수
            for (int i = 0; i < citations.length; i++) {
                if (maxUse <= desc[i])
                    count++;
            }
            //System.out.println(maxUse + " : " + count);
            if (count >= maxUse) // h(count)번 이상 인용된 논문이 h(maxUse)편 이상이면
                return maxUse;
            maxUse--;
        }
        return maxUse;
    }
}
