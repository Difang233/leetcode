public class $0206$ReverseLinkedList {
    public static void main(String[] args) {
        $0203$RemoveLinkedListElements.printLinkedList(reverseList($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3}))); //3 2 1
        $0203$RemoveLinkedListElements.printLinkedList(reverseList($0203$RemoveLinkedListElements.genLinkedList(new int[]{1}))); //1
        $0203$RemoveLinkedListElements.printLinkedList(reverseList($0203$RemoveLinkedListElements.genLinkedList(new int[]{})));
        $0203$RemoveLinkedListElements.printLinkedList(reverseListRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3})));
        $0203$RemoveLinkedListElements.printLinkedList(reverseListRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1})));
        $0203$RemoveLinkedListElements.printLinkedList(reverseListRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{})));
    }

    /**
     * 迭代法：使用三个指针，分别指向当前元素及当前元素的前后元素，每次将当前元素的next指针指向前一个元素
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    static ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next;
        while (curr != null){
            //需要将当前元素的下一个元素记录下来，因为下面要修改next指针，如果不记录会丢失后面的记录
            next = curr.next;
            //将当前元素的next指针执行上一个元素
            curr.next = prev;
            //将prev指向当前元素
            prev = curr;
            //将当前元素指向上面记录的下一个元素
            curr = next;
        }
        return prev;
    }

    /**
     * 递归法：
     * 其实还有一种递归法可以通过迭代法改写，这里是想尝试一种新的方法（这个方法的空间复杂度更高，因此并不建议）
     * 1.先从第一个元素依次入栈，直到最后一个元素为止
     * 2.开始出栈，除最后一个元素外，每个元素将下一个元素的next指针指向自己，并将自己的next指针设为null(避免链表成环)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    static ListNode reverseListRecursive(ListNode head){
        //head == null是为了保证传入空链表时不会报NPE，head.next == null是递归的停止条件
        if (head == null || head.next == null){
            return head;
        }
        //返回最后一个元素，即反转后链表的第一个元素
        ListNode ret = reverseListRecursive(head.next);
        //将当前元素的下一个元素的next指针指向当前元素
        head.next.next = head;
        //将当前元素的next指针设为null，避免在最后形成环
        head.next = null;
        return ret;
    }
}
