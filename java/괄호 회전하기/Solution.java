class Solution {
    public int solution(String s) {
        int answer = 0;
        // 괄호를 담은 변수
        String[] parenthesis = {"[]" , "()" , "{}"};
        
        for (int i = 0; i < s.length(); i++) {
            // 문자 회전
            String str = s.substring(i) + s.substring(0, i);
            // 괄호를 담은 변수로 replace 할건데 몇번 기준으로 돌려야할지는 감이 안잡혀서
            // 무겁게 100으로 설정했는데 통과는 했다...
            int number = 0;
            while (number != 100) {
                for (int j = 0; j < parenthesis.length; j++) {
                    str = str.replace(parenthesis[j] , "");
                }
                // 문자열 길이가 0이라는 뜻은 다 지워졌다는 의미
                if (str.length() == 0) {
                    answer++;
                    break;
                }
                
                number++;
            }
        }
        
        return answer;
    }
}