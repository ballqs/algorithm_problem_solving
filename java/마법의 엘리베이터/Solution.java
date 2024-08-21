class Solution {
    public int solution(int storey) {
        int cnt = 0;
        
        while(storey > 0){
            int nam = storey % 10;
            if(nam > 5){
                cnt += (10 - nam);
                storey = storey / 10 + 1;
            }else if(nam == 5){
                if((storey % 100 / 10) > 4){
                    cnt += nam;
                    storey = storey / 10 + 1;
                }else{
                    cnt += nam;
                    storey = storey / 10;
                }
            }else{
                cnt += nam;
                storey = storey / 10;
            }
        }
    
        return cnt;
    }
}