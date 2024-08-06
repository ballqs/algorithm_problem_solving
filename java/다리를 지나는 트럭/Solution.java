import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList<>();
        
        int time = 1;
        int idx = 0;
        int sum = truck_weights[idx];
        
        queue.add(new int[]{truck_weights[idx++] , time});
        
        while (queue.size() > 0) {
            time++;
            
            int[] truck = queue.peek();
            if (time - truck[1] == bridge_length) {
                sum -= truck[0];
                queue.poll();
            }
            
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                queue.add(new int[]{truck_weights[idx++] , time});
            }
        }
        
        return time;
    }
}