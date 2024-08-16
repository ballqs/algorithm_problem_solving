import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] position1 = {0 , 0 , 1 , -1};
        int[] position2 = {1 , -1 , 0 , 0};
        
        boolean[][] visible = new boolean[maps.length][maps[0].length()];
        
        Stack<int[]> myStack = new Stack<>();
        
        for(int i = 0; i < maps.length; i++){
            int mapLen = maps[i].length();
            for(int j = 0; j < mapLen; j++){
                if(maps[i].charAt(j) == 'X'){
                    continue;
                }
                
                int sum = 0;
                
                myStack.push(new int[]{i, j});
                while(!myStack.isEmpty()){
                    int[] takeXY = myStack.pop();
                    int tX = takeXY[0];
                    int tY = takeXY[1];
                    
                    if(visible[tX][tY]){
                        continue;
                    }
                    
                    visible[tX][tY] = true;
                    
                    sum += maps[tX].charAt(tY) - '0';
                    
                    for(int k = 0; k < 4; k++){
                        int cX = tX + position1[k];
                        int cY = tY + position2[k];
                        
                        if(cX < 0 || cX >= maps.length ||
                          cY < 0 || cY >= maps[i].length() ||
                          maps[cX].charAt(cY) == 'X'){
                            continue;
                        }
                        
                        myStack.push(new int[]{cX, cY});
                    }
                }
                
                if(sum > 0){
                    list.add(sum);
                }
            }
        }
        
        if(list.size() < 1){
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}