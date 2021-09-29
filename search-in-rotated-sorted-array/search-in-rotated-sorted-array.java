class Solution {
    public int search(int[] A, int target) {
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
        
        int ns = e;
        if(A[ns] == target) return ns;
        
        
        s = 0;
        e = ns;
        while(s<e){
            f = (s+e)/2;
            if(A[f] == target){
                return f;
            }
            
            if(A[f] < target){
                s = f+1;
            }else {
                e = f;
            }
        }
        
        s = ns;
        e = A.length-1;
        while(s<e){
            f = (s+e)/2+1;
            if(A[f] == target){
                return f;
            }
            
            if(A[f] < target){
                s = f;
            }else {
                e = f-1;
            }
        }
        
        return -1;
        
    }
}