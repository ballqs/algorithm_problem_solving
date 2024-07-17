import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 1번지표 : R , T
        // 2번지표 : C , F
        // 3번지표 : J , M
        // 4번지표 : A , N
        Map<String , Integer> mbti = new HashMap<>();
        mbti.put("R" , 0); mbti.put("T" , 0);
        mbti.put("C" , 0); mbti.put("F" , 0);
        mbti.put("J" , 0); mbti.put("M" , 0);
        mbti.put("A" , 0); mbti.put("N" , 0);
        
        // mbti 선택지에 따른 점수 정리
        for (int i = 0; i < survey.length; i++) {
            String res = tendency(survey[i] , choices[i]);
            int num = score(choices[i]);
            if (!res.equals("X")) {
                int n = mbti.get(res);
                mbti.replace(res , (n + num));
            }
        }
        
        // 1~4번 지표대로 mbti 추려내기
        String[] arr = {"RT" , "CF" , "JM" , "AN"};
        for (int i = 0; i < arr.length; i++) {
            String first_str = arr[i].charAt(0) + "";
            String second_str = arr[i].charAt(1) + "";
            
            if (mbti.get(first_str) < mbti.get(second_str)) {
                answer += second_str;
            } else {
                answer += first_str;
            }
        }
        
        
        return answer;
    }
    
    // 성향 조사
    public String tendency(String survey , int choice) {
        if (choice < 4) {
            return survey.charAt(0) + "";
        } else if (choice > 4) {
            return survey.charAt(1) + "";
        } else {
            return "X";
        }
    }
    
    // 선택지에 따른 점수
    public int score(int choice) {
        int num = 0;
        switch(choice){
            case 1:     // 매우 비동의
            case 7:     // 매우 동의
                num = 3;
                break;
            case 2:     // 비동의
            case 6:     // 동의
                num = 2;
                break;
            case 3:     // 약간 비동의
            case 5:     // 약간 동의
                num = 1;
                break;
            case 4:     // 모르겠음
                num = 0;
                break;
        }
        return num;
    }
}