class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs(level, path):
            if level==n:
                res.append(path[:])
                return

            for i in range(n):
                if check[i]==0:
                    check[i]=1
                    path[level] = nums[i]
                    dfs(level+1, path)
                    check[i] = 0

        n = len(nums)
        check = [0]*n
        res = []
        path = [0]*n
        dfs(0, path)
        return res