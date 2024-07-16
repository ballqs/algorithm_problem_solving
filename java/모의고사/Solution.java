import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first_pattern = {1, 2, 3, 4, 5};
        int[] second_pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 정답을 맞춘 횟수
        int[] test_result = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(first_pattern[i%5] == answers[i]){
                test_result[0]++;
            }
            if(second_pattern[i%8] == answers[i]){
                test_result[1]++;
            }
            if(third_pattern[i%10] == answers[i]){
                test_result[2]++;
            }
        }
        
        // 몇번 학생이 정답을 어느정도 맞췄는지 담기위한 변수
        Map<String, Integer> result = new HashMap<>();
        result.put("1" , test_result[0]);
        result.put("2" , test_result[1]);
        result.put("3" , test_result[2]);
        
        // 정렬을 위한 List화
        List<String> reverse = new ArrayList<>(result.keySet());

        // Value 값으로 내림차순 정렬
        reverse.sort((o1, o2) -> result.get(o2).compareTo(result.get(o1)));
        
        // 이제 1등만 추려내면 되는 작업
        ArrayList<Integer> res = new ArrayList<>();
        for(String key : reverse){
            if(res.isEmpty()){
                res.add(Integer.parseInt(key));
            }else if(result.get(Integer.toString(res.get(0))).equals(result.get(key))){
                res.add(Integer.parseInt(key));
            }
        }
        
        // answer에 담기
        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}