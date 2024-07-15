import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 명예의 전당
        ArrayList<Integer> hof = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            // 명예의 전당 변수에 추가
            hof.add(score[i]);
            // 명예의 전당 변수 역정렬
            Collections.sort(hof, Collections.reverseOrder());
            
            if(hof.size() > k){ // 변수 크기가 k보다 클 경우
                answer[i] = hof.get(k - 1);
            }else{              // 변수 크기가 k보다 같거나 작을 경우
                answer[i] = hof.get(hof.size() - 1);
            }
        }
        return answer;
    }
}