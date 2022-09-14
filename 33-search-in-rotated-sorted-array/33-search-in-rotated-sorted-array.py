class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # pivot 찾기 : 최솟값을 찾는 binary search
        def find_pivot(nums):
            lt, rt = 0, len(nums)-1
            while lt < rt:
                mid = (lt+rt)//2
                if nums[mid] > nums[rt]:
                    lt = mid+1
                else:
                    rt = mid
            return lt

        pivot = find_pivot(nums)

        # 피벗 기준 이진검색
        n = len(nums)
        lt, rt = 0,  n-1
        while lt<=rt:
            mid = (lt+rt)//2
            real_mid = (mid+pivot)%n       # 중앙의 위치 mid에서 pivot만큼 이동하고, 배열의 길이를 초과할 경우 %로 회전될 수 있도록 처리
            # 타켓과 값을 비교하는 부분은 mid가 아닌 mid_pivot을 기준으로 하되, left와 right는 mid를 기준으로 이동한다.
            if nums[real_mid] < target:
                lt = mid+1
            elif nums[real_mid] > target:
                rt = mid-1
            else:
                return real_mid
        return -1


        pivot = find_pivot(nums,0,len(nums)-1)
        return pivot