import java.util.*;
class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            int result = 1;
            place : for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        result = dfs(places[i] , j , k);
                        if (result == 0){
                            break place;
                        }
                    }
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
    
    public int dfs(String[] place , int j , int k) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{j , k , 0});
        boolean[][] flag = new boolean[5][5];
        
        while (!stack.isEmpty()) {
            int[] info = stack.pop();
            flag[info[0]][info[1]] = true;
            
            if (info[2] > 2) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = info[0] + x[i];
                int newY = info[1] + y[i];
                
                if (newX >= 0 && newX < 5 &&
                    newY >= 0 && newY < 5) {
                    
                    if (flag[newX][newY]) {
                        continue;
                    }
                    
                    char c = place[newX].charAt(newY);
                    
                    if (c == 'P' && info[2] < 2) {
                        return 0;
                    } else if(c == 'O' && info[2] < 3) {
                        stack.add(new int[]{newX , newY , info[2] + 1});
                    }
                }
            }
        }
        return 1;
    }
}