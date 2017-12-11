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
    1. Recursive solution
    2. Priority queue
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

// recursion
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) return null;
        return mergeKLists(lists, 0, lists.size()-1);
    }
    
    private ListNode mergeKLists(List<ListNode> lists, int low, int high) {
        if (low == high) {
            return lists.get(low);
        } else if (low < high) {
            int mid = low + (high - low) / 2;
            ListNode left = mergeKLists(lists, low, mid), right = mergeKLists(lists, mid+1, high);
            return mergeTwoLists(left, right);
        }
        return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
	ListNode dummyhead = new ListNode(-1);
        ListNode runner = dummyhead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if (l1 != null) {
	    runner.next = l1;
	}
        if (l2 != null) {
	    runner.next = l2;
	}
        return dummyhead.next;
    }
}

// priority queue
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val) {
                    return -1;
                } else if (o1.val==o2.val) {
                    return 0;
                } else { 
                    return 1;
                }
            }
        });
        ListNode dummyhead = new ListNode(-1);
        ListNode runner = dummyhead;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            runner.next = queue.poll();
            runner = runner.next;
            if (runner.next != null) {
                queue.add(runner.next);
            }
        }
        return dummyhead.next;
    }
}
