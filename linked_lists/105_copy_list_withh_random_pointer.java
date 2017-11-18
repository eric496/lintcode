/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.

Challenge
    Could you solve it with O(1) space?
*/

/*
Thought process:
    Use a hashmap and two passes: one pass copies nodes, one pass copies next and random pointers.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// O(n) time and O(n) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        while (runner != null) {
            map.put(runner, new RandomListNode(runner.label));
            runner = runner.next;
        }
        runner = head;
        while (runner != null) {
            map.get(runner).next = map.get(runner.next);
            map.get(runner).random = map.get(runner.random);
            runner = runner.next;
        }
        return map.get(head);
    }
}

// O(1) space 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode runner = head, next;
    	// first round: make copy of each node,
    	// and link them together side-by-side in a single list.
    	while (runner != null) {
    	    next = runner.next;
    	    RandomListNode copy = new RandomListNode(runner.label);
    	    runner.next = copy;
    	    copy.next = next;
    	    runner = next;
    	}
    	// second round: assign random pointers for the copy nodes.
    	runner = head;
    	while (runner != null) {
    	    if (runner.random != null) {
    		runner.next.random = runner.random.next;
    	    }
    	    runner = runner.next.next;
    	}
    	// third round: restore the original list, and extract the copy list.
    	runner = head;
    	RandomListNode dummyHead = new RandomListNode(-1);
    	RandomListNode copy, copyRunner = dummyHead;
    	while (runner != null) {
    	    next = runner.next.next;
    	    // extract the copy
    	    copy = runner.next;
    	    copyRunner.next = copy;
    	    copyRunner = copy;
    	    // restore the original list
    	    runner.next = next;
    	    runner = next;
    	}
    	return dummyHead.next;
    }
}
