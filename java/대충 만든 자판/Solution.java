import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // int[] answer = {}; 를 int[] answer = new int[targets.length]; 변경
        int[] answer = new int[targets.length];
        
        // answer의 배열 길이 값을 지정한 변수 선언
        int checkNum = 0;
        
        //1) keymap를 2차배열로 만드는 작업. (꼭 필요해보이진 않음...)
        ArrayList<String>[] key = new ArrayList[keymap.length];
        for(int i = 0; i < keymap.length; i++){
            // 1차 배열안에 배열 선언
            key[i] = new ArrayList<String>();
            for(int j = 0; j < keymap[i].length(); j++){
                // 문자열을 문자 하나씩 분리하여 변수에 저장
                key[i].add(keymap[i].substring(j , j+1));
            }
        }
        
        //2) targets의 길이만큼 반복문
        for(int k = 0; k < targets.length; k++){
            // targets[k]의 문자열 길이
            int targetsLen = targets[k].length();
            // answer에 담을 합계 변수 선언
            int hap = 0;
            
            //3) targets[k]의 문자열 길이만큼 반복문
            //   길이만큼 돌려서 최소 몇번을 눌러야하는지 구하기 위함
            for(int m = 0; m < targetsLen; m++){
                // min값을 100으로 설정(제한사항에 최대 길이가 100이기 때문)
                int min = 100;
                // targets[k] 가 "ABCD" 일 경우 substring으로 짤라내기 작업
                String c = targets[k].substring(m , m + 1);
                
                //4) keymap를 2차배열로 만든 그 배열 반복문 돌리기
                for(int i = 0; i < key.length; i++){
                    for(int j = 0; j < key[i].size(); j++){
                        // key[i]에 돌고 있는 문자값 추출
                        String b = key[i].get(j);
                        //5) 현재 돌고 있는 targets[k]의 문자와 key[i]에서 돌고 있는 문자를 비교
                        if(c.equals(b)){
                            //6) 최소 수치 찾기
                            if(j < min){
                                min = j + 1;
                            }
                            break;
                        }
                    }
                }
                //7-1) min의 값이 설정 안되어 있을 경우 일치하는게 없기에 -1 처리후 break
                if(min == 100){
                    hap = -1;
                    break;
                }
                
                //7-2) min의 값을 hap에 합산
                hap += min;
            }
            
            //8) answer에 담기
            answer[checkNum] = hap;
            checkNum++;
        }
        
        return answer;
    }
}