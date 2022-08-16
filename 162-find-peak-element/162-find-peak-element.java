class Solution {
    public int binarySearch(int[] nums, int l, int r) {
		int answer = 0;
		int n = nums.length;
		
		if(nums.length==1) return 0;
		
		while(l <= r) {
			int mid = (l+r)/2;
			// 경계 조건
			if(mid==0) {
				if(nums[mid] > nums[mid+1]) {
					answer = mid;
					break;
				}else {
					l = mid+1;
					continue;
				}
			}
			
			if(mid==n-1) {
				if(nums[mid] > nums[mid-1]) {
					answer = mid;
					break;
				}else {
					r = mid-1;
					continue;
				}
			}
			
			if(nums[mid]<=nums[mid-1] && nums[mid]>=nums[mid+1]) {
				r = mid-1;
			}else if(nums[mid]>=nums[mid-1] && nums[mid]<=nums[mid+1]) {
				l = mid+1;
			}else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
				answer = mid;
				break;
			}else if(nums[mid]<=nums[mid-1] && nums[mid]<=nums[mid+1]) {
//				System.out.println("홈: "+mid);
				int a1 = binarySearch(nums, l,mid-1);
				int a2 = binarySearch(nums, mid+1, r);
				answer = Math.max(a1, a2);
				break;
			}
		}
		
		return answer;
	}
    public int findPeakElement(int[] nums) {
        int n = nums.length;
		int answer = binarySearch(nums, 0, n-1);
		return answer;
    }
}