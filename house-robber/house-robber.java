class Solution {
    public int rob(int[] nums) {
        int[][] d= new int[nums.length][2];
        // d[i][0] : 0~i까지 i를 선택, 최대 값
        // d[i][1] : 0~i까지 i를 선택 안함, 최대 값
        d[0][0] = nums[0];
        d[0][1] = 0;
        
        for(int i=1; i<nums.length; i++){
            d[i][0] = d[i-1][1] + nums[i];
            d[i][1] = Math.max(d[i-1][0],d[i-1][1]);
        }
        
        int n = nums.length-1;
        return Math.max(d[n][0], d[n][1]);
    }
}