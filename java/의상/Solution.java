import java.util.*;
class Solution {
    public int solution(String[][] data) {
        int answer = 1;
        Map<String , Integer> clothes = new HashMap<>();
        for (String[] str : data) {
            if (clothes.containsKey(str[1])) {
                clothes.put(str[1] , clothes.get(str[1]) + 1);
            } else {
                clothes.put(str[1] , 1);
            }
        }
        for (String str : clothes.keySet()) {
            answer *= (clothes.get(str) + 1);
        }
        
        return answer - 1;
    }
}