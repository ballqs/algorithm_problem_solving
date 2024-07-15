class Solution {
    public String solution(int[] food) {
        String answer = "";
        // food[0] 물이며 그 이외의 번지는 음식이며 낮은 칼로리 순이다.
        // 홀수인 경우 -1 처리를 한다.
        
        // 1번 음식부터 차례대로
        for(int i = 1; i < food.length; i++){
            int num = food[i] / 2;
            answer = addStr(answer , i , num);
        }
        
        // 0 더하기
        answer += "0";
        
        // (food.length - 1)번 음식부터 차례대로
        for(int i = food.length - 1; i > 0; i--){
            int num = food[i] / 2;
            answer = addStr(answer , i , num);
        }
        
        return answer;
    }
    
    // 공통적인 부분을 따로 빼서 작성
    public String addStr(String str , int add , int num){
        for(int j = 0; j < num; j++){
            str += add;
        }
        return str;
    }
}