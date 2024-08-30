import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double , Integer> map = new HashMap<>();
        
        for (int weight : weights) {
            map.put((double) weight , map.getOrDefault((double) weight , 0) + 1);
        }
        
        for (double weight : map.keySet()) {
            for (int i = map.get(weight) - 1; i > 0; i--) {
                answer += i;
            }
        }
        
        double[] calcs = {2.0/3.0 , 2.0/4.0 , 3.0/2.0 , 3.0/4.0 , 4.0/2.0 , 4.0/3.0};
        for (int weight : weights) {
            for (double calc : calcs) {
                double d = weight * calc;
                if (map.containsKey(d)) {
                    answer+=map.get(d);
                }
            }
            map.put((double) weight , map.get((double) weight) - 1);
        }
        
        
        return answer;
    }
}