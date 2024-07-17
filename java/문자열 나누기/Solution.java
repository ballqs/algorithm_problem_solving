class Solution {
    public int solution(String s) {
        int answer = 0;
        // 사용할 메소드 toCharArray()
        // 맨처음에 읽은 글자를 담고 읽어가면서 카운트한다.
        // 다른 글자들을 읽어가면서 카운트한다.
        // 카운트한 2개가 같을 경우 위의 값을 초기화 한다.
        
        String str = "";    // 처음 읽은 글자 기록용도
        int n = 0;  // 맨처음 나온 글자 카운트
        int m = 0;  // 다른 글자들 카운트
        for(char c : s.toCharArray()){
            if(str.equals("")){ // 처음 읽을 글자값이 빈값이면
                str = c + "";   // 담기
                n++;
            }else{
                if(str.equals(c + "")){ // 처음 읽은 글자와 같으면
                    n++;
                }else{                  // 다르면
                    m++;
                }
                
                if(n == m){ // 카운트한 값이 같으면 초기화
                    str = "";
                    n = 0;
                    m = 0;
                    answer++;
                }
            }
        }
        
        // 마지막까지 진행했는데 초기화가 안된 경우
        if(n > 0){
            answer++;
        }
        
        return answer;
    }
}