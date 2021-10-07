class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> li = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i])){
                li.add(nums[i]);
            }else{
                hs.add(nums[i]);
            }
        }
               
        return li;
    }
}