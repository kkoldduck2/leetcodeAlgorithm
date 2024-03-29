class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # base cases
        n = len(nums)
        if n + k == 0:
            return []
        if k == 1:
            return nums

        # 큐가 현재 sliding window 안에 있는 인덱스만 갖도록 한다.
        # 현재(i)보다 작은 값을 갖는 모든 element의 index는 삭제한다. -> max보다 작으므로
        def clean_deque(i):
            # remove indexes of elements not from sliding window
            if deq and deq[0] == i-k:
                deq.popleft()

            # remove from deq indexes of all elements
            # which are smaller than current element nums[i]
            while deq and nums[i] > nums[deq[-1]]:
                deq.pop()


        # init deque and output
        deq = deque()
        max_idx = 0
        for i in range(k):
            clean_deque(i)
            deq.append(i)
            # compute max in nums[:k]
            if nums[i] > nums[max_idx]:
                max_idx = i
        output = [nums[max_idx]]

        # build output
        for i in range(k, n):
            clean_deque(i)
            deq.append(i)
            output.append(nums[deq[0]])
        return output