class Solution {
    public boolean containsDuplicate(int[] nums) {
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]== nums[i]) return true;
            // if(li.contains(nums[i])){
            //     return true;
            // }
            // li.add(nums[i]);
        }
        return false;
    }
}