import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> sum = new ArrayList<>();
        
        //두 개의 값 뽑아서 더하는 로직
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i == j){ //i 와 j가 같으면 넘기기
                    continue;
                }else{
                    sum.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        //중복 제거 로직
        ArrayList<Integer> unique = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            //값이 있는지 검사
            if (!unique.contains(sum.get(i))) {
                //없다면 추가
                unique.add(sum.get(i));
            }
        }
        
        //정렬
        //Arrays.sort(unique); => 배열일때 사용
        //ArrayList 정렬시에는 아래와 같이 사용
        Collections.sort(unique);
        
        //중복제거한 고유 합계값의 길이만큼 배열 선언
        int[] answer = new int[unique.size()];
        
        for(int i = 0; i < unique.size(); i++){
            answer[i] = unique.get(i);
        }
        
        return answer;
    }
}