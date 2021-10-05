class Solution {
    public int longestConsecutive(int[] nums) {
        // key : 숫자(nums[i]), value: 인덱스(i)
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] parent = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], i);
            parent[i] = i;
            
            if(hm.containsKey(nums[i]-1)){
                int pidx = hm.get(nums[i]-1);
                parent[i] = pidx;
            }
            if(hm.containsKey(nums[i]+1)){
                int cidx = hm.get(nums[i]+1);
                parent[cidx] = i;
            }
            
        }
        
        int maxlen = 0;
        int[] d= new int[nums.length];
        for(int i=0; i<parent.length; i++){
            int x = i;
            int cnt =1;
            while(parent[x] != x){
                if(d[x]!=0){
                    cnt += (d[x]-1);
                    break;
                }
                cnt++;
                x = parent[x];
            }
            // cnt++;
            d[i] = cnt;
            maxlen = Math.max(maxlen, cnt);
        }
        
        return maxlen;
        
    }
}