class Solution {
    public String solution(String my_string, int[] indices) {
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
    }
}