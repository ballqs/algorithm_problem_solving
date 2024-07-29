import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String , Integer> wantList = new HashMap<>();
        Map<String , Integer> purchList = new HashMap<>();
        int purchNum = 0;
        
        for (int i = 0; i < want.length; i++){
            wantList.put(want[i] , 0);
            purchList.put(want[i] , number[i]);
            purchNum += number[i];
        }
        
        for (int i = 0; i < discount.length - purchNum + 1; i++) {
            for (int j = 0; j < purchNum; j++) {
                if (wantList.containsKey(discount[i + j])) {
                    wantList.replace(discount[i + j] , wantList.get(discount[i + j]) + 1);
                } else {
                    break;
                }
            }
            if (compare(purchList , wantList)) {
                answer++;
            }
            wantList = clear(wantList , want);
        }
        
        
        return answer;
    }
    
    public Map<String , Integer> clear(Map<String , Integer> map , String[] list) {
        for (String obj : map.keySet()) {
            map.put(obj , 0);
        }
        return map;
    }
    
    public boolean compare(Map<String , Integer> map1 , Map<String , Integer> map2) {
        for (String obj : map1.keySet()) {
            if (map1.get(obj) != map2.get(obj)) {
                return false;
            }
        }
        return true;
    }
}