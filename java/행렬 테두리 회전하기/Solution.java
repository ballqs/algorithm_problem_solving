import java.util.*;
class Solution {
    int[][] arr;
    int[] answer;
        
    int startX;
    int startY;
    int endX;
    int endY;
    int cnt;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        
        create(rows , columns);
        
        for (int i = 0; i < queries.length; i++) {
            startX = queries[i][0] - 1;
            startY = queries[i][1] - 1;
            endX = queries[i][2];
            endY = queries[i][3];
            
            cnt = ((endX - startX) + (endY - startY) - 4) * 2 + 4;
            
            endX--;
            endY--;
            
            List<Integer> list = extract(queries[i]);
            Integer n = list.get(list.size() - 1);
            list.add(0 , n);
            list.remove(list.size() - 1);
            
            answer[i] = Collections.min(list);
            
            apply(list);
        }
        
        return answer;
    }
    
    public void create(int rows , int columns) {
        arr = new int[rows][columns];
        
        int number = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = number++;
            }
        }
    }
    
    public List<Integer> extract(int[] querie) {
        List<Integer> list = new ArrayList<>();
        int row = startX;
        int col = startY;
        
        for (int i = 0; i < cnt; i++) {
            if (row == startX && col + 1 <= endY) {
                list.add(arr[row][col++]);
            } else if (col == endY && row + 1 <= endX) {
                list.add(arr[row++][col]);
            } else if (row == endX && col - 1 >= startY) {
                list.add(arr[row][col--]);
            } else if (col == startY && row - 1 >= startX) {
                list.add(arr[row--][col]);
            }
        }
        
        return list;
    }
    
    public void apply(List<Integer> list) {
        int row = startX;
        int col = startY;
        
        for (int i = 0; i < cnt; i++) {
            if (row == startX && col + 1 <= endY) {
                arr[row][col++] = list.get(i);
            } else if (col == endY && row + 1 <= endX) {
                arr[row++][col] = list.get(i);
            } else if (row == endX && col - 1 >= startY) {
                arr[row][col--] = list.get(i);
            } else if (col == startY && row - 1 >= startX) {
                arr[row--][col] = list.get(i);
            }
        }
    }
}