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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;
            for(int i=0;i<k; i++){
                if(kth.next == null){
                    return dummy.next;
                }
                kth = kth.next;
            }
            ListNode nextGroup = kth.next;
            ListNode prev = nextGroup;
            ListNode current = prevGroup.next;
            ListNode temp1 = prevGroup.next;

            while(current!=nextGroup){
                ListNode temp2 = current.next;
                current.next = prev;
                prev =  current;
                current = temp2;
            }
            prevGroup.next = kth;
            prevGroup = temp1;
        }
    }
}