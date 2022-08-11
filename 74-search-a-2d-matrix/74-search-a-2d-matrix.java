class Solution {
    int lowerBound(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length-1;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(arr[mid]>target) {
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
		return lo-1;
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. target이 몇 번째 row 범위 안에 속하는지 찾는다.
		int[] rowArr = new int[matrix.length];
		for(int i=0; i<rowArr.length; i++) {
			rowArr[i] = matrix[i][0];
		}
		int row = lowerBound(rowArr, target);
		if(row<0 || row>=rowArr.length) return false;
		// 2. 해당 row에서 target의 위치를 찾는다. 
		
		int lo = 0;
		int hi = matrix[row].length-1;
		int rst = 0;
		
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(matrix[row][mid]==target) {
				return true;
			}else if(matrix[row][mid]<target) {
				lo = mid +1;
			}else {
				hi = mid -1;
			}
		}
		
		return false;
    }
}