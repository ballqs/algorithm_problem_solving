class Solution {
    public int[] solution(int brown, int yellow) {
        int hap = brown + yellow;
        
        int w = 0;
        int h = 0;
        
        // 약수 구하기
        for(int i=1; i < hap; i++){
            if(hap % i == 0){
                int num1 = hap / i;
                
                if(yellow == (i - 2) * (num1 - 2) && i >= num1){
                    w = i;
                    h = num1;
                    break;
                }
            }
        }
        return new int[]{w , h};
    }
}