class Solution {
    public int findMin(int[] A) {
        int s = 0;
        int e = A.length-1;
        int f = 0;
        while(s<e){
            f = (s+e)/2;
            
            // 최소값은 f 이후에
            if(A[f] > A[e]){
                s = f+1;
            }else{
                e = f;
            }
        }
        
        int res = Math.min(A[s], A[e]);
        return res;
        
    }
}