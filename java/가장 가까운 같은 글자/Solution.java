import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 문자를 한글자씩 쪼개서 담을 변수 마련 => ArrayList
        // ※다른 언어였다면 이렇게 할 필요가 없었을지두...
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            str.add(s.substring(i , i + 1));
        }
        
        // answer에 담을 로직 구현
        for(int i = 0; i < str.size(); i++){
            // 초기값 -1로 설정
            int n = -1;
            // 현재 검증해야할 문자
            String m = str.get(i);
            for(int j = i - 1; j >= 0; j--){
                // 문자가 일치한지 검증
                if(str.get(j).equals(m)){
                    // 현재 검증해야할 문자의 몇번 앞에 해당 글자가 있는지 계산
                    n = i - j;
                    break;
                }
            }
            // answer에 담기
            answer[i] = n;
        }
        
        return answer;
    }
}