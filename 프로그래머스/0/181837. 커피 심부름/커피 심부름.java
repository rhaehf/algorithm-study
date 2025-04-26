class Solution {
    public int solution(String[] order) {
        int cntAmericano = 0;
        int cntCafelatte = 0;
        
        for (String menu : order) {
            if (menu.contains("cafelatte"))
                cntCafelatte++;                
            else
                cntAmericano++;
        }
        
        return cntAmericano * 4500 + cntCafelatte * 5000;
    }
}