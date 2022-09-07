class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def sortby(x,y):
            if x+y > y+x:
                return -1
            elif x == y:
                return 0
            else:
                return 1

        largest_num = [str(x) for x in nums]
        largest_num.sort(key=cmp_to_key(sortby))
        rst = ''.join(largest_num)

        return '0' if rst[0] == '0' else rst