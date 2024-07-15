import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // 1 ~ k => 사과 등급
        // 한 상자에 m개씩 담아 포장
        // 사과는 상자 단위로만 판매하며, 남는 사과는 버립니다
        
        // 내림차순
        Integer[] reverse_score = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(reverse_score, Comparator.reverseOrder());
        
        int n = 0;
        int min = 9;    //k의 값은 3<= k <= 9 라서 9라는 최대값 설정
        for(int i = 0; i < reverse_score.length; i++){
            //최소값 구하기
            if(min > reverse_score[i]){
                min = reverse_score[i];
            }
            
            //카운트하는 n의 값과 m이 같은 경우 아래와 같은 로직 태우기
            if(++n == m){
                answer += min * m;  //계산하여 answer에 더하기
                min = 9;            //min의 값 9로 초기화
                n = 0;              //n 카운트 0로 초기화
            }
        }
        
        return answer;
    }
}