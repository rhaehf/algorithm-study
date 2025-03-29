import java.util.*;

class Solution {
    public String[] solution(String myStr) {
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
    }
}