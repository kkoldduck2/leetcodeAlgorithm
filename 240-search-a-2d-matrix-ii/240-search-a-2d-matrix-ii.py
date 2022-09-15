class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for r in range(len(matrix)):
            if(matrix[r][0]<=target and matrix[r][-1]>=target):
                index = bisect.bisect_left(matrix[r], target)
                if index>=0 and index<len(matrix[r]) and matrix[r][index] == target:
                    return True
        return False