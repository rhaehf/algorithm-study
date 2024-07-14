class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for(int[] a : queries){
            int s = a[0];
            int e = a[1];
            int k = a[2];
            
            for(int i=s; i <= e; i++){  
                // 0은 모든 수의 배수이다.             
                    if(i % k == 0){
                    arr[i] = arr[i] +1;
                }
            }
        }
        return arr;
    }
}