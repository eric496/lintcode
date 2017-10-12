/*
Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.

Example
    Given lists:
    [
      2->4->null,
      null,
      -1->null
    ],
    return -1->2->4->null.
*/

/*
Thought process:
    Mergesort
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

// mergesort
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size() == 0) return null;
        return mergeKLists(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeKLists(List<ListNode> lists, int low, int high) {
        if(low == high) {
            return lists.get(low);
        } else if (low < high){
            int mid = low + (high - low) / 2;
            ListNode left = mergeKLists(lists, low, mid);
            ListNode right = mergeKLists(lists, mid + 1, high);
            return mergeTwoLists(left, right);
        }
        return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode runner = new ListNode(Integer.MIN_VALUE);
        ListNode head = runner;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if(l1 != null) runner.next = l1;
        if(l2 != null) runner.next = l2;
        return head.next;
    }
}
