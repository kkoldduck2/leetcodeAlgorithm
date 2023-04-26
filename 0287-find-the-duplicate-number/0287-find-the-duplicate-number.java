class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0];
        
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == num) {
        		return num;
        	}
        	num = nums[i];
        }
        return num;
    }
}