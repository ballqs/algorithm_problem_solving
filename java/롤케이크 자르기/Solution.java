import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer , Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : topping) {
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        
        for (int i : topping) {
            int t = map.get(i);
            set.add(i);
            if (t == 1) {
                map.remove(i);
            } else {
                map.put(i , t - 1);
            }
            
            if (map.size() == set.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}