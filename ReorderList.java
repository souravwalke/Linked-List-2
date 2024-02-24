// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Approach - Use two pointer approach to get the middle of the list. Reverse the second half of the list. Alternatively connect the first half and the reversed second half.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Two pointers to get the middle of the list
        ListNode fHalf = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode sHalf = reverse(slow);

        merge(fHalf, sHalf);

    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private void merge(ListNode fHalf, ListNode sHalf) {

        while (fHalf != null) {
            ListNode fhalfNext = fHalf.next;
            ListNode shalfNext = sHalf.next;
            fHalf.next = sHalf;

            if (fhalfNext == null) {
                break;
            }

            sHalf.next = fhalfNext;
            fHalf = fhalfNext;
            sHalf = shalfNext;
        }

    }
}