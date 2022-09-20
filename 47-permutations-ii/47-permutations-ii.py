class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def dfs(cnt, li, used):
            if cnt == len(nums):
                rst.append(li[:])
                return
            # print(li)
            for i in range(len(nums)):
                if i>0 and used[i-1]==0 and nums[i-1]==nums[i]:
                    continue
                if used[i]==0:
                    li.append(nums[i])
                    used[i]=1
                    dfs(cnt+1, li, used)
                    used[i] = 0
                    li.pop()

        nums.sort()
        rst = []
        used = [0]*len(nums)
        dfs(0, [], used)
        return rst