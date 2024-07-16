class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 각 기사에게는 1번부터 number까지의 번호가 지정
        // 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
        // 제한수치보다 높을 경우 제한수치의 공격력을 구매
        
        int[] divisor_cnt = new int[number];
        for(int i = 1; i <= number; i++){
            
            // 예를 들어 10의 약수가 2일때  다른 약수는 10/2가 되므로 5라는 약수를 알게 된다.
            for(int j = 1; j * j <= i; j++){
                // 1 ~ number 까지 각 숫자별로 약수가 몇개인지 계산
                if(j * j == i){
                    divisor_cnt[i - 1]++;
                }else if(i % j == 0){
                    divisor_cnt[i - 1]+=2;
                }
                
                // 약수의 개수가 limit를 넘을 경우 해당 숫자는 power로 대체
                if(divisor_cnt[i - 1] > limit){
                    divisor_cnt[i - 1] = power;
                    break;
                }
            }
        }
        
        // 총합계 구하기
        for(int i = 0; i < divisor_cnt.length; i++){
            answer += divisor_cnt[i];
        }
        
        return answer;
    }
}