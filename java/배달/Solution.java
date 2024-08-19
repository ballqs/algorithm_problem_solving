import java.util.*;
class Solution {
    Map<Integer , List<Integer[]>> map;
    Set<Integer> set;
    
    public int solution(int N, int[][] road, int K) {

        map = new HashMap<>();
        set = new HashSet<>();
        set.add(0);
        
        boolean[] flag = new boolean[N];
        flag[0] = true;
        
        for (int i = 0; i < road.length; i++){
            create(road[i][0] - 1 , road[i][1] - 1 , road[i][2]);
            create(road[i][1] - 1 , road[i][0] - 1 , road[i][2]);
        }
        
        dfs(0 , flag , K , 0 , 1);

        return set.size();
    }
    
    public void create(int key , int value1 , int value2) {
        if (map.containsKey(key)) {
            List<Integer[]> list = map.get(key);
            list.add(new Integer[]{value1 , value2});
            map.put(key , list);
        } else {
            List<Integer[]> list = new ArrayList<>();
            list.add(new Integer[]{value1 , value2});
            map.put(key , list);
        }
    }
    
    public void dfs(int villageNum , boolean[] flag , int k , int n , int cnt) {
        List<Integer[]> list = map.get(villageNum);
        
        for (int i = 0; i < list.size(); i++) {
            Integer[] arr = list.get(i);
            
            if (flag[arr[0]] || (n + arr[1]) > k) {
                continue;
            }
            
            set.add(arr[0]);
            flag[arr[0]] = true;
            dfs(arr[0] , flag , k , n + arr[1] , cnt + 1);
            flag[arr[0]] = false;
        }
    }
}