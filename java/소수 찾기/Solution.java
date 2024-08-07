import java.util.*;

class Solution {
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        String[] str = new String[numbers.length()];
        boolean[] visit = new boolean[numbers.length()];
        
        int idx = 0;
        for (char c : numbers.toCharArray()) {
            str[idx++] = c + "";
        }
        
        dfs(str , visit , 0);
        
        return answer;
    }
    
    public void dfs(String[] str , boolean[] visit , int number) {
        if (number > 1) {
            if (!set.contains(number) && discriminator(number)) {
                set.add(number);
                answer++;
            }
        }
        
        for (int i = 0; i < str.length; i++) {
            if (visit[i]) {
                continue;
            }
            
            visit[i] = true;
            dfs(str , visit , (number * 10) + Integer.parseInt(str[i]));
            visit[i] = false;
        }
    }
    
    public boolean discriminator(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}