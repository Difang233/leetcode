public class $0141$HasCycle {
    /**
     * 经典的快慢指针法，fast指针一次移动两步，slow指针移动一步，如果两个指针能指向同一个元素，说明有环，
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    static boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
