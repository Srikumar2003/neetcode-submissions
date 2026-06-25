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
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        List<ListNode> arr = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            arr.add(curr);
            curr = curr.next;
        }

        int  i = 0; 
        int j = arr.size() - 1;
        while(i < j){
            arr.get(i).next = arr.get(j);
            i++;
            if(i >= j){
                break;
            }
            arr.get(j).next = arr.get(i);
            j--;
        }
        arr.get(i).next = null;
    }
}
