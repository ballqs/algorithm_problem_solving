import java.util.*;
class Solution {
    // 방향 설정 : 동 , 서 , 남 , 북
    int[] x = {1 , -1 , 0 ,   0};
    int[] y = {0 ,  0 , 1 ,  -1};
    
    int rows , cols;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        // 행 , 열 크기 설정
        rows = land.length;
        cols = land[0].length;
        
        for (int col = 0; col < cols; col++)
        {
            // 열 기준으로 방문 여부를 관리
            boolean[][] visit = new boolean[rows][cols];
            int hap = 0;
            
            for (int row = 0; row < rows; row++)
            {
                // 해당 지점(행 , 열)
                int target = land[row][col];
                
                // 해당 지점에 1이 담겨 있으면 석유로 판단! 그리고 방문되어 있지 않으면 통과
                if (target == 1 && !visit[row][col])
                {
                    hap += bfs(row , col , land , visit);
                }
            }
            
            // 합의 크기가 결과값보다 크면 설정
            if (hap > answer) answer = hap;
        }
        
        return answer;
    }
    
    // BFS 알고리즘
    public int bfs(int startRow , int startCol , int[][] land , boolean[][] visit)
    {
        // 들어온 시점에서 크기 1
        int result = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow , startCol});
        
        // 방문 여부 설정
        visit[startRow][startCol] = true;
        
        while (!queue.isEmpty())
        {
            // 큐에서 꺼내기
            int[] xy = queue.poll();
            
            // 4방향으로 반복문 돌기
            for (int i = 0; i < 4; i++)
            {
                int nextRow = xy[0] + x[i];
                int nextCol = xy[1] + y[i];
                
                if (nextRow > -1 && nextRow < rows &&
                   nextCol > -1 && nextCol < cols &&
                   !visit[nextRow][nextCol] && land[nextRow][nextCol] == 1)
                {
	                  // 방문여부를 설정
                    visit[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow , nextCol});
                    result++;
                }
            }
        }
        
        return result;
    }
}