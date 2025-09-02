import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        Queue<Integer> active = new LinkedList<>();
        
				// 플레이어는 24명 고정
        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
						
						// 증설시 담기는 값을 만료 시간으로 했기에 i보다 같거나 작으면 서버 폐쇄
            while (!active.isEmpty() && active.peek() <= i) {
                active.poll();
            }

            int current = active.size();

						// 증설된 서버 < 필요한 서버
            if (current < need) {
		            // 새로 증설해야하는 서버 = 필요한 서버 - 증설된 서버
                int newServer = need - current;
                count += newServer;
                // 새로 증설해야하는 서버를 반복문만큼 돌려서 증설
                for (int j = 0; j < newServer; j++) {
		                // i + k로 처리하는 이유!
		                // ★현재 시각 i가 만료 시간으로 처리하기 위함
                    active.offer(i + k);
                }
            }
        }

        return count;
    }
}