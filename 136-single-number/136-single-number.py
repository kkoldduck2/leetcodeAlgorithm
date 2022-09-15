class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        cnt_num= defaultdict(int)
        for num in nums:
            cnt_num[num] += 1

        for key in cnt_num:
            if cnt_num[key]==1:
                return key