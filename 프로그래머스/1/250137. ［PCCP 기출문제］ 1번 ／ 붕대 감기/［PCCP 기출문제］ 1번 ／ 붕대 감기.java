class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healTime = bandage[0]; // 시전 시간
        int perHeal = bandage[1]; // 초당 회복량
        int plusHeal = bandage[2]; // 추가 회복량
        int heal = health; // 현재 회복량
        int time = 0; // 현재 시간
        
        for (int[] a : attacks) {
            int attackTime = a[0]; // 공격 시간
            int damage = a[1]; // 피해량
            
            // 이전 공격과의 시간 차이가 시전 시간보다 많으면 회복하기
            int healTry = attackTime - time - 1;
            if (1 <= healTry) {
                int check = 0; // 연속 성공 체크
                
                // 다음 공격이 남은 시간동안 회복
                while (healTry-- > 0 && heal <= health) {
                    heal += perHeal; // 회복
                    check++; // 연속 성공 증가
                    
                    // 연속 성공 달성하면 추가 회복량 더하고, 연속 성공 초기화
                    if (check == healTime) {
                        heal += plusHeal;
                        check = 0;
                    }
                }
                //System.out.println("회복 후 - " + attackTime + " 이전 : " + heal);
            }
            
            // 회복하고 난 후 최대 체력 이상이라면 조정
            if (heal > health) heal = health;
             
            heal -= damage; // 공격
            time = attackTime; // 시간 세팅
            //System.out.println("공격 후 - " + attackTime + " : " + heal);
            
            // 체력이 0 이하가 되면 조기 종료
            if (heal < 0) return -1;
        }
        
        return heal > 0 ? heal : -1;
    }
}
