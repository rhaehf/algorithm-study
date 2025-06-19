class Solution {
    public int solution(String s) {
        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < 10; i++) {
            if (s.contains(alphabets[i])) {
                s = s.replace(alphabets[i], Integer.toString(i));
                //System.out.println(s);
            }            
        }

        return Integer.parseInt(s);
    }
}
