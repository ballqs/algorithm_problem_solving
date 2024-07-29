class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int secondLen = arr1[0].length;
        
        int[][] rearr2 = new int[arr2[0].length][arr2.length];
        
        for (int i = 0; i < arr2[0].length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                rearr2[i][j] = arr2[j][i];
            }
        }
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < rearr2.length; j++) {
                for (int k = 0; k < secondLen; k++) {
                    answer[i][j] += arr1[i][k] * rearr2[j][k];
                }
            }
        }
        return answer;
    }
}