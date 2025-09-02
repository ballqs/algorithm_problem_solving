import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 증설한 서버 담는 곳
        List<Integer> expansionserver = new LinkedList<>();
        
        // players 시간별 플레이어 이용자
        for (int i = 0; i < players.length; i++)
        {
            int player = players[i];
            
            // 증설된 서버의 만료시간이 0이면 제거
            while (expansionserver.size() > 0)
            {
                if (expansionserver.get(0) == 0)
                {
                    expansionserver.remove(0);
                }
                else
                {
                    break;
                }
            }
            
            // (증설된 서버 < 플레이어 / 증설 기준) 으로 서버 증설
            while (expansionserver.size() < player / m)
            {
                expansionserver.add(k);
                answer++;
            }
            
            // 증설된 서버 만료 처리 방식을 남은 시간 -1씩 감소하는 방법
            for (int j = 0; j < expansionserver.size(); j++)
            {
                int hour = expansionserver.get(j) - 1;
                if (hour >= 0) expansionserver.set(j , hour);
            }
        }
        return answer;
    }
}