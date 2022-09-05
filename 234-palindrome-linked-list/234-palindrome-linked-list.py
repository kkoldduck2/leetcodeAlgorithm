# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # 연결 리스트 입력값을 파이썬의 리스트로 변환해 푼다
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        rev = None  #느린 런너가 연결리스트를 역순으로 생성
        slow = fast = head
        
        #런너를 이용해 역순 연결 리스트 구성
        while fast and fast.next:   # next가 존재하지 않을 때까지
            fast = fast.next.next
            # 다중 할당 : 같은 시점에 한꺼번에 변수 할당. 
            rev, rev.next, slow = slow, rev, slow.next
            # 아래와 같이 3줄로 할당하면 문제가 안풀린다.
            # rev = slow
            # rev.next = rev
            # slow = slow.next
        
        # 홀수, 짝수일 때 처리 다름 -> 홀수면 slow 한칸 더 이동 (가운데 값 처리 안함)
        if fast:
            slow = slow.next
        
        # 팰린드롬 여부 확인
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
        
        return rev == None  # rev == None이니
        
        
        