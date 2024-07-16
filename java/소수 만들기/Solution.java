import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        ArrayList<Integer> hap = new ArrayList<>();
        
        // 반복문 돌려서 3개를 더한 모든 경우의 수를 구함
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    hap.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        // 구해진 숫자가 소수인지 판별
        for(int i = 0; i < hap.size(); i++){
            boolean flag = false;
            for(int j = 2; j < hap.get(i); j++){
                if(hap.get(i) % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }
        }

        return answer;
    }
}