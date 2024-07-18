import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 유저가 신고한 멤버가 누구누구인지 담기 위한 변수(Set를 통한 중복 제거)
        Map<String , Set<String>> report_history = new HashMap<>();
        
        // 신고 당한 횟수를 기록하는 변수 초기값
        Map<String , Integer> receive_cnt = new HashMap<>();
        
        for (String member_name : id_list) {
            report_history.put(member_name , new HashSet<String>());
            receive_cnt.put(member_name , 0);
        }
        
        // 멤버가 누구를 신고 했는지 담는 곳
        for (int i = 0 ; i < report.length; i++) {
            String[] report_info = report[i].split(" ");    // A유저가 B유저를 신고했다.
            Set<String> set_list = report_history.get(report_info[0]);
            set_list.add(report_info[1]);                   // set에 담기
            report_history.replace(report_info[0] , set_list);
        }
        
        // 신고당한 횟수 카운트하는 로직
        for (int i = 0 ; i < id_list.length; i++) {
            String member = id_list[i];
            Set<String> set_report_list = report_history.get(member);
            
            // 해당 멤버가 누굴 신고 했는지 리스트로 돌기
            for (String report_name : set_report_list) {
                int cnt = receive_cnt.get(report_name);
                receive_cnt.replace(report_name , cnt + 1);
            }
        }
        
        // 각 멤버가 신고했던 다른 멤버들의 정지유무에 따른 메일 받을 횟수 증가 로직
        for (int i = 0 ; i < id_list.length; i++) {
            String member = id_list[i];
            Set<String> set_report_list = report_history.get(member);
            
            // 해당 멤버가 누굴 신고 했는지 리스트로 돌기
            for (String report_name : set_report_list) {
                int cnt = receive_cnt.get(report_name);
                if(cnt >= k){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}