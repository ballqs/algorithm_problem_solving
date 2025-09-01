import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 박스 담을 공간 만들기
        int h = n%w > 0 ? n/w + 1 : n/w;
        int[][] boxlist = new int[h][w];
        
        // 0: 왼→오, 1: 오→왼
        int direction = 0;
        int col = 0;
        int row = 0;
        
        // 목표 박스의 열 인덱스
        int targetCol = 0;
        
        // 박스 쌓기
        for( int i = 0; i < n; i++ )
        {
            if ( i > 0 && i % w == 0 )
            { // 새로운 행 시작
                row++;
                if (direction == 0) 
                {
                    direction = 1;
                    col = w - 1;
                }
                else
                {
                    direction = 0;
                    col = 0;
                }
            }
            boxlist[row][col] = (i + 1);
            
            // 목표 박스의 열 저장
            if (num == (i + 1)) targetCol = col;
            
            // 다음 열 계산
            if (direction == 0) col++;
            else col--;
        }
        
        // 목표 박스를 꺼내기 위해 몇 번 손을 대야 하는지 계산
        for (int i = boxlist.length - 1; i >= 0; i-- )
        {
            if (boxlist[i][targetCol] != 0) answer++;
            if (boxlist[i][targetCol] == num) break;
        }
        
        return answer;
    }
}