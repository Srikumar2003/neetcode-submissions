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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> nodes =  new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            nodes.add(curr);
            curr = curr.next;
        }

        int rIndex = nodes.size() - n;
        if(rIndex == 0){
            return head.next;
        }
        nodes.get(rIndex - 1).next = nodes.get(rIndex).next;
        return head;
    }
}