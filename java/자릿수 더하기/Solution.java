import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // int -> string 형변환
        String str = Integer.toString(n);
        // string 자리수대로 추출해서 int로 변환 후 덧셈
        for(int i = 0; i < str.length(); i++){
            answer += Integer.parseInt(str.substring(i , i + 1));
        }

        return answer;
    }
}