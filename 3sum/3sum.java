class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        // a + b + c (a<b<c)
        for(int a=0; a<nums.length-2; a++){
            if(a>=1 && nums[a-1]==nums[a]) continue;
            int b = a+1;
            int c = nums.length-1;
            while(b<c){
                int sum = nums[a] + nums[b] + nums[c];
                if(sum==0){
                    answer.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while(b<c && nums[b] == nums[b+1]) b++;
                    while(b<c && nums[c]==nums[c-1]) c--;
                    b++;
                    c--;
                }else if(sum < 0){
                    b++;
                }else{
                    c--;
                }
            }
        }
        
        return answer;
    }
}