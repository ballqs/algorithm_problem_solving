import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        final int complete = 100;
        Map<Integer , Integer> func = new HashMap<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int mok = (complete - progresses[i]) / speeds[i];
            int nam = (complete - progresses[i]) % speeds[i];
            if (nam > 0) {
                mok++;
            }
            func.put(i + 1 , mok);
        }
        
        Map<Integer , Integer> distribution = new HashMap<>();
        int preDay = 0;
        int idx = 1;
        for (int i : func.keySet()) {
            if (preDay < func.get(i)) {
                preDay = func.get(i);
                idx++;
            }
            distribution.put(idx , distribution.getOrDefault(idx, 0) + 1);
        }
        
        int[] answer = new int[distribution.size()];
        int n = 0;
        for (int i : distribution.keySet()) {
            answer[n++] = distribution.get(i);
        }
        
        return answer;
    }
}