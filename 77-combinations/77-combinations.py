class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def dfs(idx, cnt, rst):
            if cnt == k:
                ans.append(rst.copy())
                return

            for i in range(idx+1, n+1):
                rst.append(i)
                dfs(i, cnt+1, rst)
                rst.pop()

        ans = []
        for i in range(1, n+1):
            dfs(i, 1, [i])

        return ans