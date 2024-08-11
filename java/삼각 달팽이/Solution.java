class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];
        
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = new int[i + 1];
        }
        
        int row = 0;
        int col = 0;
        int level = 0;
        
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            result[row][col] = i + 1;
            switch (level % 3) {
                case 0:
                    if (row + 1 < n && result[row + 1][col] == 0) {
                        row++;
                    } else {
                        col++;
                        level++;
                    }
                    break;
                case 1:
                    if (col + 1 <= row && result[row][col + 1] == 0) {
                        col++;
                    } else {
                        row--;
                        col--;
                        level++;
                    }
                    break;
                case 2:
                    if (row - 1 >= 0 && col - 1 >= 0 && result[row - 1][col - 1] == 0) {
                        row--;
                        col--;
                    } else {
                        row++;
                        level++;
                    }
                    break;
            }
        }
        
        int z = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < result[i].length; j++) {
                answer[z++] = result[i][j];
            }
        }
        
        return answer;
    }
}