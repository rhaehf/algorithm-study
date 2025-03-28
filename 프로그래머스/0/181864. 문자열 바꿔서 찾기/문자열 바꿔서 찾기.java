class Solution {
    public int solution(String myString, String pat) {
        // 한 번에 이어서 적어도 됨
        myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
        
        /*
        myString = myString.replace("A", "C");
        myString = myString.replace("B", "A");
        myString = myString.replace("C", "B");
        */
        
        return myString.contains(pat) ? 1 : 0;
    }
}