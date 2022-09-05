# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 == None:
            return list2
        if list2 == None:
            return list1
    
        total_list: Optional[ListNode] = None
        if list1.val >= list2.val:
            total_list = ListNode(list2.val, self.mergeTwoLists(list1, list2.next))
        else:
            total_list = ListNode(list1.val, self.mergeTwoLists(list1.next, list2))
        
        return total_list