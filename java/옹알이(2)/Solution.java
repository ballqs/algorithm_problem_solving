class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        // "aya", "ye", "woo", "ma" 만 발음할수 있다.
        // 연속으로 같은 발음은 어렵다.
        String[] babbling_list = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++){
            String pre_str = "";
            // 외부 플래그 => 기본값으로 true 설정 flag2의 기준으로 while문 빠져나올지 말지 정함
            boolean flag = true;
            while(flag){
                // 내부 플래그 => 기본값으로 true 설정 indexOf로 찾은 값이 0이 아니거나 pre_str 값이랑 일치 안했을때만 false 처리
                boolean flag2 = true;
                
                for(int j = 0; j < babbling_list.length; j++){
                    // 해당 문자열의 길이가 없어졌다는 것은 전부 발음 했다는 의미
                    if(babbling[i].length() == 0){
                        answer++;
                        flag = false;
                        break;
                    }
                    
                    // 찾은 문자가 0이 아닌 경우는 발음이 불가능하다는 의미
                    // 또한 pre_str와 babbling_list[i]가 같은 경우 같은 발음했다는 의미
                    if(babbling[i].indexOf(babbling_list[j]) == 0 &&
                      !pre_str.equals(babbling_list[j])){
                        // 했던 발음 저장
                        pre_str = babbling_list[j];
                        // 발음만큼 자르기
                        babbling[i] = babbling[i].substring(babbling_list[j].length() , babbling[i].length());
                        // 위 조건에 속할수 있었기 때문에 false 처리
                        flag2 = false;
                    }
                }
                
                // 빠져나가기
                if(flag2){
                    flag = false;
                }
            }
        }
        
        return answer;
    }
}