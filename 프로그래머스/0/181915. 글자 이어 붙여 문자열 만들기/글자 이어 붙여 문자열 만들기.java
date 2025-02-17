class Solution {
    public String solution(String my_string, int[] index_list) {
        // 좀 더 짧은 버전
        StringBuilder sb = new StringBuilder();

        for (int idx : index_list)
            sb.append(my_string.charAt(idx));
        
        /* 내가 풀이한 방법
        char[] array = new char[my_string.length()];
        for(int i=0; i < my_string.length(); i++){
            array[i] = my_string.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int index : index_list){
            sb.append(array[index]);
        }
        */
        
        return sb.toString();
    }
}