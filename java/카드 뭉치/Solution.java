class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int cnum1 = 0;  // cards1 count용
        int cnum2 = 0;  // cards2 count용
        
        for(int i = 0; i < goal.length; i++){
            // cards1의 총 길이를 cnum1가 넘지 않고 goal[i]의 값과 cards1[cnum1]이 같을 경우
            if(cards1.length > cnum1 && goal[i].equals(cards1[cnum1])){
                cnum1++;
                
            // cards2의 총 길이를 cnum2가 넘지 않고 goal[i]의 값과 cards2[cnum2]이 같을 경우
            }else if(cards2.length > cnum2 && goal[i].equals(cards2[cnum2])){
                cnum2++;
            }else{
                // 다 속하지 않을 경우 "No"
                return "No";
            }
        }
        // 무사히 진행했을 경우 "Yes"
        return "Yes";
    }
}