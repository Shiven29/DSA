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
    public ListNode partition(ListNode head, int x) {
        ListNode lessdummy = new ListNode(0);
        ListNode greaterdummy = new ListNode(0);

        ListNode less = lessdummy;
        ListNode great = greaterdummy;
        ListNode current = head;

        while(current!=null){
            ListNode nextNode = current.next;
            if(current.val < x){
                less.next = current;
                less = less.next;
            }else{
                great.next = current;
                great = great.next;
            }
            current = nextNode;
        }
        less.next = greaterdummy.next;
        great.next = null;
        return lessdummy.next;
    }
}