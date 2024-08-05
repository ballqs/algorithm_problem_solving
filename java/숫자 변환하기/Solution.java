import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Map<Integer , Integer> map = new HashMap<>();
        map.put(x , 0);
        
        while (map.size() > 0) {
            List<Integer> sortList = new ArrayList<>(map.keySet());
            Collections.sort(sortList);
            for (Integer idx : sortList) {
                int value = map.get(idx);
                map.remove(idx);
                
                if (idx + n <= y && !map.containsKey(idx + n)) {
                    map.put(idx + n , value + 1);
                }
                if (idx * 2 <= y && !map.containsKey(idx * 2)) {
                    map.put(idx * 2 , value + 1);
                }
                if (idx * 3 <= y && !map.containsKey(idx * 3)) {
                    map.put(idx * 3 , value + 1);
                }
            }
            
            for (Integer idx : Set.copyOf(map.keySet())) {
                if (idx == y) {
                    return map.get(idx);
                }
            }
        }
        
        if (x == y) return 0;
        return answer;
    }
}