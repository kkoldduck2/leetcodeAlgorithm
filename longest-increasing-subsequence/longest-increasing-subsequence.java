class Solution {
    // d[i]  : i번째 원소를 가장 마지막으로 포함하는  LIS
    public int lengthOfLIS(int[] A) {
        int[] d = new int[A.length+1];
        
        for(int i=0; i<A.length; i++){
            d[i] = 1;
        }
        
        int max = 0;
        for(int i=1; i<A.length; i++){
            for(int j=0; j<i; j++){
                if(A[j] < A[i]){
                    d[i] = Math.max(d[i], d[j]+1);
                    // max = Math.max(d[i], max);
                }
            }
        }
        
        for(int i=0; i<d.length; i++){
            max = Math.max(d[i], max);
        }
        
        return max;
        
    }
}