import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        // 두번째 방법
        String[] arr = myStr.split("[abc]+");
        //System.out.println(Arrays.toString(arr));
        
        // 빈 문자열을 제외한 요소만 새 리스트에 담기
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            if (!str.isEmpty())
                list.add(str);
        }
        
        return arr.length == 0 ? new String[] {"EMPTY"} : list.toArray(new String[0]);   
        
        /*
        // 첫번째 방법
        ArrayList<String> list = new ArrayList<>();
        String str = "";

        for (char c : myStr.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (str != "")
                    list.add(str);
                str = "";
            } else {
                str += c;
            }
        }
        
        char last = myStr.charAt(myStr.length() - 1);
        if (last != 'a' || last != 'b' || last != 'c')
            list.add(str);

        if (list.size() == 1 && list.contains("")){
            list.remove("");
            list.add("EMPTY");
        }            
        //System.out.println(list);

        return list.toArray(String[]::new);
        */
    }
}