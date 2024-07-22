import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] cnt = new int[10000000];
        for (int i : tangerine) {
            cnt[i - 1]++;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                list.add(cnt[i]);
            }
        }
        
        Collections.sort(list);
        
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            answer++;
            if (sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}