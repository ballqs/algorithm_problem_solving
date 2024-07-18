class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int max = -1000000;
        int min = 1000000;
        for(int i = 0; i < numbers.length; i++){
            if(Integer.parseInt(numbers[i]) > max){
                max = Integer.parseInt(numbers[i]);
            }
            if(Integer.parseInt(numbers[i]) < min){
                min = Integer.parseInt(numbers[i]);
            }
        }
        return min + " " + max;
    }
}