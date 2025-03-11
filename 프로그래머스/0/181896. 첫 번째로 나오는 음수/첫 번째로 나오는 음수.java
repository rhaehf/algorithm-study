class Solution {
    public int solution(int[] num_list) {
        // 두번째 방법
        for(int i = 0; i < num_list.length; i++)
            if (num_list[i] < 0)
                return i;
        
        return -1;
        
        // 첫번째 방법
        /*
        boolean flag = true;
        int index = 0;
        
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] < 0){
                flag = false;
                index = i;    
                break;
            }               
        }
        
        return flag ? -1 : index;
        */
    }
}