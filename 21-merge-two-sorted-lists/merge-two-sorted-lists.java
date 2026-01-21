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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode result = new ListNode(0);
        ListNode l = result;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                l.next = t1;
                t1 = t1.next;
            }
            else{
                l.next = t2;
                t2 = t2.next;
            }
            l = l.next;
        }
        if(t1 == null){
            l.next = t2;
        }else{
            l.next = t1;
        }

        return result.next;
    }
}