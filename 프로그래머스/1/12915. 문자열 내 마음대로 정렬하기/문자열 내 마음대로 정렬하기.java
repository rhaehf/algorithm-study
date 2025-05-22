import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {        
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        
        // 문자열의 n번째 인덱스 기준으로 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.charAt(n) - b.charAt(n);
            }
        });        
        //System.out.println(list);
        
        // n번째 인덱스가 같으면 사전순으로 다시 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.charAt(n) == b.charAt(n))
                    return a.compareTo(b);
                else return 0;
            }
        });        
        //System.out.println(list);
        
        return list.toArray(new String[0]);
    }
}
