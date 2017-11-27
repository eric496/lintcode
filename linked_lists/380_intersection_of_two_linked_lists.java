/*
Write a program to find the node at which the intersection of two singly linked lists begins.

Notice
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.

Example
    The following two linked lists:
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3
    begin to intersect at node c1.

Challenge
    Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

/*
Thought process:
    Observe that the intersection always occurs at the "tail" part of the two lists. We look for the beginning node of the intersection by iteratively comparing a pair of nodes from both lists. 
    Thus in order to let two lists reach at the beginning node of the intersection at the same time, we will let the longer list starts to traverse by n nodes beforehand, where n is the length difference 
    of the two lists. Next, we traverse both lists at the same pace, and look for the first identical node to return.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        while (pointA != null) {
            pointA = pointA.next;
            lengthA++;
        }
        while (pointB != null) {
            pointB = pointB.next;
            lengthB++;
        }
        pointA = headA;
        pointB = headB;
        if (lengthA < lengthB) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                pointB = pointB.next;
            }
        } else if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                pointA = pointA.next;
            }
        }
        while (pointA != null) {
            if (pointA == pointB) return pointA;
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return null;
    }
} 
