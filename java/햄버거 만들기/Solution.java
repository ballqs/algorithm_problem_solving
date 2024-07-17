import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // ※상수가 포장하는 규칙 [1 , 2 , 3 , 1]
        
        // ArrayList에 담는 작업
        ArrayList<Integer> proc_ingr = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            proc_ingr.add(ingredient[i]);
        }
        
        // 반복문 시작
        for (int i = 0; i < proc_ingr.size(); i++) {
            // 해당 index에서 1231를 검증하기 위해 +3 하는 것
            if (i + 3 < proc_ingr.size()) {
                int first = proc_ingr.get(i);
                int second = proc_ingr.get(i + 1);
                int third = proc_ingr.get(i + 2);
                int fourth = proc_ingr.get(i + 3);
                
                // 1231 검증
                if (first == 1 && second == 2 &&
                  third == 3 && fourth == 1){
                    
                    // 4번 제거!
                    proc_ingr.remove(i);    // 1제거
                    proc_ingr.remove(i);    // 2제거
                    proc_ingr.remove(i);    // 3제거
                    proc_ingr.remove(i);    // 1제거
                    
                    answer++;
                    
                    // i값을 조금 앞으로 당겨서 재검증
                    if (i - 3 < 0) {
                        i = -1;
                    } else {
                        i = i - 3;
                    }
                }
            }
        }
        
        
        return answer;
    }
}