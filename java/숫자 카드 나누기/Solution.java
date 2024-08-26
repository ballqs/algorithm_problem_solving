class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int resultA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            resultA = gcb(resultA , arrayA[i]);
        }
        
        int resultB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            resultB = gcb(resultB , arrayB[i]);
        }
        
        for(int i : arrayB) {
            if(i % resultA == 0) {
                resultA = 0;
                break;
            }
        }
        
        for(int i : arrayA) {
            if(i % resultB == 0) {
                resultB = 0;
                break;
            }
        }
        
        return Math.max(resultA , resultB);
    }
    
    public int gcb(int n , int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
}