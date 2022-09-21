class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(idx, sum, rst):
            if sum > target:
                return
            if sum == target:
                ans.append(rst.copy())
                return

            for i in range(idx, len(candidates)):
                rst.append(candidates[i])
                dfs(i, sum+candidates[i], rst)
                rst.pop()

        ans = []
        dfs(0,0,[])
        # for i in range(len(candidates)):
        #     dfs(i, candidates[i], [candidates[i]])
        return ans