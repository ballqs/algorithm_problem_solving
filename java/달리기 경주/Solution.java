import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 랭크를 담을 경기
        Map<String , Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i] , i);
        }
        
        // ※경주 진행중 1등 선수의 이름은 불리지 않는다!!
        for (String call : callings){
            int call_player_rank = rank.get(call);
            
            // 불린 선수의 바로 앞에 있는 선두자
            String front_player = players[call_player_rank - 1];
            
            // 순서 변경
            players[call_player_rank] = front_player;
            players[call_player_rank - 1] = call;
            
            // 랭크 변경
            rank.replace(call , call_player_rank - 1);
            rank.replace(front_player , call_player_rank);
        }
        
        return players;
    }
}