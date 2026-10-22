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
    public ListNode reverseList(ListNode head) {

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];
        temp = head;

        for (int i = 0; i < size; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        int left = 0;
        int right = size - 1;

        while (left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;

            left++;
            right--;
        }

        temp = head;

        for (int i = 0; i < size; i++) {
            temp.val = arr[i];
            temp = temp.next;
        }

        return head;
    }
}