import java.util.*;
class Solution {
    // target보다 (작거나) 같은 값이 처음으로 나오는 인덱스 리턴
    public static int lowerBound(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		
		while(low<high) {
			int mid = (low+high)/2;
			if(nums[mid] >= target) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		return high;
	}
    
    // target보다 (크거나) 같은 값이 처음으로 나오는 인덱스 리턴
    public static int upperBound(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		
		while(low<high) {
			int mid = (low+high)/2;
			if(nums[mid] <= target) {
				low = mid+1;
			}else{
				high = mid;
			}
		}
		return low-1;
	}
    public static int[] searchRange(int[] nums, int target) {
		int start = lowerBound(nums,target);
		int end = upperBound(nums, target);
		
		if(start>=nums.length || end >=nums.length || nums[start]!=target || nums[end] != target) return new int[] {-1, -1};
		return new int[] {start, end};
    }
}