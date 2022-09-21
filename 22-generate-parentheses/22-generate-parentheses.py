class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def dfs(str, left):
            if left['(']==0 and left[')']==0:
                rst.append(str)
                return

            if left['('] < left[')'] and left[')'] > 0:
                left[')'] = left[')'] - 1
                dfs(str + ')', left)
                left[')'] = left[')'] + 1

            if left['('] > 0:
                left['('] = left['('] - 1
                dfs(str + '(', left)
                left['('] = left['('] + 1

        left = {'(': n, ')':n}
        rst = []
        dfs("",left)
        return rst