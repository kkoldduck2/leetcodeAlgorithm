class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] d= new int[1001];
        // d[i] = d[i-nums[j]] (j=0 ~ nums.length)
        for(int i=0; i<nums.length; i++){
            d[nums[i]] = 1;
        }
        
        for(int i=1; i<=target; i++){
            for(int j=0; j<nums.length; j++){
                if(i-nums[j] >=0 )
                    d[i] += (d[i-nums[j]]);
                
            }
        }
        return d[target];
    }
}