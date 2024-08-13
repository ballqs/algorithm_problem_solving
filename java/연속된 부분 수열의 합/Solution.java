class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int startPoint = 0;
        int lastPoint = 0;
        int sum = 0;
        
        int returnPoint1 = 0;
        int returnPoint2 = 0;
        int min = 1000000;
        
        while (lastPoint < sequence.length) {
            if (sum < k) {
                sum += sequence[lastPoint];
                lastPoint++;
            }
            
            while (sum > k && startPoint < lastPoint) {
                sum -= sequence[startPoint];
                startPoint++;
            }
            
            if (sum == k) {
                if (min > (lastPoint - 1) - startPoint) {
                    min = (lastPoint - 1) - startPoint;
                    returnPoint1 = startPoint;
                    returnPoint2 = (lastPoint - 1);
                }
                
                sum -= sequence[startPoint];
                startPoint++;
            }
        }
        return new int[]{returnPoint1 , returnPoint2};
    }
}