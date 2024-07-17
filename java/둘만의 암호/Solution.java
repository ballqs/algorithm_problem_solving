import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        // s는 toCharArray()를 통해서 돌리며 각각 시작위치로 볼 것
        // index만큼 넘어갈때 skip에 속한 것은 넘기기
        
        // 알파벳을 담은 변수가 필요
        String alphabet_str = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        
        for(char c : s.toCharArray()){
            // char to String 형변환
            String target = c + "";
            // indexOf를 사용해서 index 찾기
            int num = alphabet_str.indexOf(target);
            int j = 0;
            for(int i = 0; i < index; i++){
                j++;
                // skip에 있는 문자의 경우 i 감소
                if(skip.indexOf(alphabet[(num + j) % 26]) > -1){
                    i--;
                }
            }
            // answer에 더하기
            answer += alphabet[(num + j) % 26];
        }
        
        return answer;
    }
}