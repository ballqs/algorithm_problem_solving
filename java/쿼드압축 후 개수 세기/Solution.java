import java.util.*;

class Solution {
    List<int[]> compressionList = new ArrayList<>();
    int[][] array;
    boolean[][] visiting;
    int len;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        array = arr;
        len = array[0].length;
        visiting = new boolean[len][len];
        
        compression(len);
        
        for (int i = 0; i < compressionList.size(); i++) {
            answer[compressionList.get(i)[3]]++;
        }
        
        return answer;
    }
    
    public void compression(int add) {
        if (add > 0) {
            for (int i = 0; i <= len - add; i += add) {
                for (int j = 0; j <= len - add; j += add) {
                    if (!visiting[i][j] && partLoop(i , j , add , array[i][j])) {
                        visitingCheck(i , j , add);
                        compressionList.add(new int[]{i , j , add , array[i][j]});
                    }
                }
            }
            compression(add / 2);
        }
    }
    
    public boolean partLoop(int xStart , int yStart , int add , int number) {
        for (int i = xStart; i < xStart + add; i++) {
            for (int j = yStart; j < yStart + add; j++) {
                if (number != array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void visitingCheck(int xStart , int yStart , int add) {
        for (int i = xStart; i < xStart + add; i++) {
            for (int j = yStart; j < yStart + add; j++) {
                visiting[i][j] = true;
            }
        }
    }
}