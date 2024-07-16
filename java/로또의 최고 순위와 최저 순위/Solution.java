import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // lottos의 길이는 6
        // lottos의 모든 원소는 0 ~ 45
        // 0은 알아볼수 없는 숫자를 의미
        // 0를 제외한 나머지 숫자는 고유함
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        // 1) 0의 개수가 몇개인지 검사
        int zero_cnt = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero_cnt++;
            }else{
                break;
            }
        }
        
        // 2) 0를 제외한 나머지 숫자가 몇개정도 맞는지 검사
        int coincide_cnt = 0;
        for(int i = zero_cnt; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    coincide_cnt++;
                    break;
                }
            }
        }
        
        // 3) 로또 순위 정하는 방식을 적용하여 순위 매김
        answer[0] = rank(coincide_cnt + zero_cnt);
        answer[1] = rank(coincide_cnt);
        
        return answer;
    }
    
    /** 로또의 순위를 정하는 방식 */
    public int rank(int n){
        int result = 0;
        switch(n){
            case 6: // 6개 번호가 모두 일치
                result = 1;
                break;
            case 5: // 5개 번호가 일치
                result = 2;
                break;
            case 4: // 4개 번호가 일치
                result = 3;
                break;
            case 3: // 3개 번호가 일치
                result = 4;
                break;
            case 2: // 2개 번호가 일치
                result = 5;
                break;
            default:// 그 외
                result = 6;
                break;
        }
        return result;
    }
}