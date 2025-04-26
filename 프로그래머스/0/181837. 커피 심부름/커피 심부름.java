class Solution {
    public int solution(String[] order) {
        int price = 0;
        
        for (String menu : order) {
            if (menu.contains("cafelatte"))
                price += 5000;
            else
                price += 4500;
        }
        
        return price;
    }
}
