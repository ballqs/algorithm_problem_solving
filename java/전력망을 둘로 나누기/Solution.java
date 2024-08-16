import java.util.*;
class Solution {
    Map<Integer , List<Integer>> map = new HashMap<>();
    int answer = 0;
    
    public int solution(int n, int[][] wires) {
        answer = n;
        
        for (int i = 0; i < wires.length; i++) {
            int target = wires[i][0];
            int connect = wires[i][1];
            input(target , connect);
            input(connect , target);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            List<Integer> startCutList = map.get(start);
            startCutList.removeIf(x -> x == end);
            map.put(start , startCutList);
            
            List<Integer> endCutList = map.get(end);
            endCutList.removeIf(x -> x == start);
            map.put(end , endCutList);
            
            int startCnt = dfs(start , n);
            int endCnt = dfs(end , n);
            
            answer = Math.min(answer , Math.abs(startCnt - endCnt));
            
            List<Integer> startAddList = map.get(start);
            startAddList.add(end);
            map.put(start , startAddList);
            
            List<Integer> endAddList = map.get(end);
            endAddList.add(start);
            map.put(end , endAddList);
        }
        
        return answer;
    }
    
    public void input(int key , int value) {
        if (!map.containsKey(key)) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key , list);
        } else {
            List<Integer> list = map.get(key);
            list.add(value);
            map.put(key , list);
        }
    }
    
    public int dfs(int start , int n) {
        int count = 0;
        
        boolean[] flag = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        
        while (!stack.isEmpty()) {
            int num = stack.pop();
            flag[num - 1] = true;
            
            List<Integer> list = map.get(num);
            for (int i = 0; i < list.size(); i++) {
                if (flag[list.get(i) - 1]) {
                    continue;
                }
                
                stack.add(list.get(i));
            }
            count++;
        }
        
        return count;
    }
    
}