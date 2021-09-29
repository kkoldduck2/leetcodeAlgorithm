class Solution {
    public boolean containsDuplicate(int[] nums) {
        // List<Integer> li = new ArrayList<>();
        Arrays.sort(nums);
    
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]== nums[i]) return true;
            // if(li.contains(nums[i])){        // 이거 시간복잡도가 O(n)임 따라서 전체 시간 복잡도는 O(n^2)가 됨
            //     return true;
            // }
            // li.add(nums[i]);
        }
        return false;
    }
}
