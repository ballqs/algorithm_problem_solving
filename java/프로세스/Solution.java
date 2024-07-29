import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }
        while (!queue.isEmpty()) {
            int priority = Collections.max(queue);
            int now = queue.poll();
            
            if (now < priority) {
                queue.add(now);
                if (location == 0) {
                    location = queue.size();
                }
            } else {
                answer++;
                if (location == 0) {
                    break;
                }
            }
            location--;
        }
        
        return answer;
    }
}