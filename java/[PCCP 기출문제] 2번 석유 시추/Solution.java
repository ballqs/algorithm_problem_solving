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
        
        // 덩어리별 ID를 부여하여 관리할 변수
        // ※ ID로 관리해야하는 이유! 열마다 덩어리 크기가 같을 수 있기에 고유 ID를 부여해야 함
        HashMap<Integer , Integer> petroleumsizes = new HashMap<>();
        int id = 1;
        
        // 덩어리의 ID를 담을 변수
        int[][] sizes = new int[rows][cols];
        
        // 열 기준으로 반복문
        for (int col = 0; col < cols; col++)
        {
            // 행 기준으로 반복문
            for (int row = 0; row < rows; row++)
            {
                // 해당 지점(행 , 열)
                int target = land[row][col];
                
                // 해당 지점에 1이 담겨 있으면 석유로 판단! 그리고 덩어리 ID 담을 변수가 초기값(0)일 경우
                if (target == 1 && sizes[row][col] == 0)
                {
                    petroleumsizes.put(id , bfs(row , col , land , sizes , id));
                    id++;
                }
            }
        }
        
        // 각 열마다 석유의 합계
        for (int col = 0; col < cols; col++) 
        {
            // 중복 제거를 위한 set 변수
            HashSet<Integer> petroleumids = new HashSet<>();
            int sum = 0;
            
            // 행 반복문
            for (int row = 0; row < rows; row++) 
            {
                // 해당 지점에 ID 고유값
                int getid = sizes[row][col];
                
                // ID가 0이 아닐 경우 덩어리가 있음! 그리고 set 변수에 담겨있지 않아야 함
                if (getid > 0 && !petroleumids.contains(getid))
                {
                    sum += petroleumsizes.get(getid);
                    petroleumids.add(getid);
                }
            }
            answer = Math.max(answer , sum);
        }
        
        return answer;
    }
    
    // BFS 알고리즘
    public int bfs(int startRow , int startCol , int[][] land , int[][] sizes , int id)
    {
        // 들어온 시점에서 크기 1
        int size = 1;
        
        // 석유의 행과 열을 담기 위한 변수
        List<int[]> cells = new ArrayList<>();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow , startCol});
        
        // 시작 지점에 id 부여
        sizes[startRow][startCol] = id;
        
        while (!queue.isEmpty())
        {
            // 큐에서 꺼내기
            int[] xy = queue.poll();
            
            // 관련 있는 위치 담기
            cells.add(xy);
            
            // 4방향으로 반복문 돌기
            for (int i = 0; i < 4; i++)
            {
                int nextRow = xy[0] + x[i];
                int nextCol = xy[1] + y[i];
                
                if (nextRow > -1 && nextRow < rows &&
                   nextCol > -1 && nextCol < cols &&
                   sizes[nextRow][nextCol] == 0 && land[nextRow][nextCol] == 1)
                {
                    // id 설정
                    sizes[nextRow][nextCol] = id;
                    queue.add(new int[]{nextRow , nextCol});
                    size++;
                }
            }
        }
        
        // 관련 위치에 덩어리 ID 설정
        for (int[] cell : cells)
        {
            sizes[cell[0]][cell[1]] = id;
        }
        
        return size;
    }
}