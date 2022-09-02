class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # idx를 rst에 포함 시킬 것인지 말 것인지를 결정한다.
        def dfs(idx, rst):
            if idx == len(nums):
                ans.append(rst.copy())
                return

            rst.append(nums[idx])
            dfs(idx+1, rst)
            rst.pop()
            dfs(idx + 1, rst)

        ans = []
        dfs(0, [])
        return ans