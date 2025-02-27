class Solution {
    public String solution(String my_string, int[] indices) {
        // 두번째 풀이
        String[] str = my_string.split("");
        for (int i = 0; i < indices.length; i++) 
            str[indices[i]] = ""; // 문자 지우기
        return String.join("", str);
        
        // 첫번째 풀이
        /*
        char[] ch = my_string.toCharArray();
        for(int index : indices){
            ch[index] = 'A';
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ch.length; i++){
            if (Character.isLowerCase(ch[i]))
                sb.append(ch[i]);            
        }
        
        return sb.toString();
        */
    }
}