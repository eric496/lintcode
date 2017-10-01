/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.

Challenge
    Could you solve it with O(1) space?
*/

/*
Thought process:
    1. O(n) time and space solution: use a hashmap and two passes: one to copy
       nodes, one to copy next and random pointers.
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
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode runner = head;
        while(runner != null) {
            map.put(runner, new RandomListNode(runner.label));
            runner = runner.next;
        }
        runner = head;
        while(runner != null) {
            map.get(runner).next = map.get(runner.next);
            map.get(runner).random = map.get(runner.random);
            runner = runner.next;
        }
        return map.get(head);
    }
}

// O(1) space

