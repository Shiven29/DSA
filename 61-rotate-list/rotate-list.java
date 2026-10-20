/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        k = k%n;
        if(k==0) return head;

        ListNode current = head;
        for(int i = 1 ; i<n-k; i++){
            current = current.next;
        }
        ListNode newTail = current;
        ListNode newHead = newTail.next;

        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = head;
        newTail.next = null;
        return newHead;
    }
}