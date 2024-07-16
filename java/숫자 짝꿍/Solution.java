import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        // X와 Y에 담긴 값이 숫자로 이뤄진 String이기에 아래와 같이 설정
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        
        // X에 담긴 String 문자열을 toCharArray로 잘라서 가져오기
        for(char c : X.toCharArray()){
            // num1이라는 배열에 해당 숫자가 어느정도 있는지 카운팅
            num1[c - '0']++;
        }
        
        // Y에 담긴 String 문자열을 toCharArray로 잘라서 가져오기
        for(char c : Y.toCharArray()){
            // num2이라는 배열에 해당 숫자가 어느정도 있는지 카운팅
            num2[c - '0']++;
        }
        
        // StringBuilder란?
        // String 클래스는 문자열을 더하게 되면 새로운 문자열 객체를 생성하므로 문자열을 더할 때마다 메모리 할당 및 해제가 발생
        // StringBuilder는 내부적으로 문자열을 가변적인 버퍼에 저장하므로 문자열을 더할 때마다 메모리를 새로 할당하지 않아도 되는 이점
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            // num1[i]와 num2[i] 중 최소값을 구해서 min에 담기
            int min = Math.min(num1[i] , num2[i]);
            for(int j = 0; j < min; j++){
                sb.append(i);
            }
        }
        
        // StringBuilder to String 형변환 방법
        answer = sb.toString();
        
        if(answer.equals("")){
            return "-1";
            
        // Integer.parseInt를 사용했을때 
        // 테스트케이스 6 ~ 10 까지 런타임 에러가 뜨는 이유
        // Integer보다 더 큰 범위를 가져와서 변환할려고 해서
        }else if(answer.replaceAll("0", "").isEmpty()){
            return "0";
        }
        
        return answer;
    }
}