class Solution {
    public int maxProduct(int[] A) {
        int curmax=1;
        int curmin=1;
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<A.length; i++){
            if(A[i]==0){
                curmax = 1;
                curmin = 1;
                res = Math.max(0, res);
                continue;
            }
            int n = A[i];
            int temp = curmax*n;
            curmax = Math.max(Math.max(curmax*n, curmin*n), n);
            curmin = Math.min(Math.min(temp, curmin*n), n);
            res = Math.max(curmax, res);
        }
        return res;
    }
}