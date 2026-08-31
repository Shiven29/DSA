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

    private ListNode mergeTwoLists(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1!=null){
            current.next= list1;
        }
        if(list2!=null){
            current.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode join = lists[0];
        for(int i=1; i<lists.length; i++){
            join = mergeTwoLists(join , lists[i]);
        }
        return join;
    }
}