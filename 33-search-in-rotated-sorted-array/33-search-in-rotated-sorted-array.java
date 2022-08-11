class Solution {
    public int lowerBound(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length-1;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(nums[mid] > target) {
				lo = mid+1;
			}else {
				hi = mid;
			}
		}
		return lo;
	}
    public int search(int[] nums, int target) {
        int n = nums.length;
        // nums 배열에서 최소값 위치 찾기
		int rot = lowerBound(nums, nums[n-1]);
		boolean flag = false;
		// target 찾기 
		int lo = rot;
		int hi = n-1;
		int rst = 0;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(nums[mid]==target) {
				flag = true;
				rst = mid;
				break;
			}else if(nums[mid] > target) {
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
		
		if(flag) return rst;
		
		lo = 0;
		hi = rot-1;
		rst = 0;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(nums[mid]==target) {
				flag = true;
				rst = mid;
				break;
			}else if(nums[mid] > target) {
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
        
		if(flag) return rst;
		return -1;
    }
}