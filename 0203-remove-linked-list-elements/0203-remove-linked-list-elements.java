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
    public ListNode removeElements(ListNode head, int val) {
        // Remove matching nodes from the beginning
        while(head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode t = head;

        while(temp != null && t != null && t.next != null) {

            if(t.next.val != val) {
                temp = temp.next;
                t = t.next;
            }
            else {
                t.next = t.next.next;
            }
        }

        return head;
    }
    }