import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] itg = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(itg , Collections.reverseOrder());
        
        int max = 0;
        for (int i = 0; i < itg.length; i++) {
            // 나머지 논문이 체크
            int nextcnt = 0;
            for (int j = i; j < itg.length; j++) {
                nextcnt++;
            }
            if (itg[i] >= nextcnt && max < itg[i]) {
                max = (i + 1);
            }
        }
        
        answer = max;
        
        return answer;
    }
}