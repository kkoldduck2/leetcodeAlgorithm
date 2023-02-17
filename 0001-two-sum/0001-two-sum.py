class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for i, num in enumerate(nums):
            hm[num] = i

        for i, num in enumerate(nums):
            if target - num in hm and hm[target - num] != i:
                return [hm[target - num], i]