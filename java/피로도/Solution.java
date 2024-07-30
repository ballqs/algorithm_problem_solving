class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] entrance = new boolean[dungeons.length];
        dfs(k, dungeons , entrance , 0);
        return max;
    }
    
    public void dfs(int k , int[][] dungeons ,boolean[] entrance , int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (entrance[i] || k < dungeons[i][0]) {
                continue;
            }
            entrance[i] = true;
            dfs(k - dungeons[i][1], dungeons , entrance , count + 1);
            entrance[i] = false;
        }
        max = Math.max(max , count);
    }
}