class Solution {
    public int solution(String myString, String pat) {
        int firstIdx = myString.indexOf(pat);
        
        if(firstIdx == -1)
            return 0;
        
        int lastIdx = myString.lastIndexOf(pat);

        int count = 0;
        for (int i = firstIdx; i <= lastIdx; i++) {
            int end = i + pat.length();
            if (myString.substring(i, end).equals(pat))
                count++;
        }

        return count;
    }
}