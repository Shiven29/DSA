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
    private ListNode merge(ListNode first , ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(first!=null && second!=null){
            if(first.val<=second.val){
                current.next = first;
                first = first.next;
            }else{
                current.next=second;
                second = second.next;
            }
            current = current.next;
        }
        if(first!=null){
            current.next = first;
        }
        if(second!=null){
            current.next = second;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode firsthalf = sortList(head);
        ListNode secondhalf = sortList(second);

        return merge(firsthalf,secondhalf);


    }
}