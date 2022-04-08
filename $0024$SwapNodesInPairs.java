public class $0024$SwapNodesInPairs {

    public static void main(String[] args) {
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{1})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3,4})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairs($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3,4,5})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3,4})));
        $0203$RemoveLinkedListElements.printLinkedList(swapPairsRecursive($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3,4,5})));
    }

    /**
     * 迭代法：可以增加一个头节点，方便操作
     * 1.指针执行头节点，交换后面两个元素，并把指针所指元素的next指针指向交换前第二个元素（即交换后第一个元素）
     * 2.移动指针到交换后第二个元素（即交换前第一个元素），重复第一步
     * 3.重复上述步骤，直到最后的元素不足两个
     * 4.返回头节点的下一个元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    static ListNode swapPairs(ListNode head) {
        //新增一个头节点，方便后面的操作
        ListNode realHead = new ListNode();
        realHead.next = head;
        //currNode首先指向头节点
        ListNode currNode = realHead, next1, next2;
        //如果currNode后面没有两个节点，则退出循环
        while (currNode.next != null && currNode.next.next != null){
            //next1和next2分别指向currNode后面两个元素，即需要交换的元素
            next1 = currNode.next;
            next2 = next1.next;
            //交换两个元素，并将currNode.next指向交换后的第一个元素
            next1.next = next2.next;
            currNode.next = next2;
            next2.next = next1;
            //currNode移动到交换后的第二个元素
            currNode = next1;
        }
        return realHead.next;
    }

    /**
     * 递归法：每次将传入的节点和它后面的节点交换，直到传入为空或传入的节点是最后一个节点为止
     * @param head
     * @return
     */
    static ListNode swapPairsRecursive(ListNode head){
        //递归的停止条件
        if (head == null || head.next == null){
            return head;
        }
        //因为每次要交换传入的节点和下一个节点，所以在递归入栈时传入下下个节点
        ListNode result = swapPairsRecursive(head.next.next);
        //head即传入的节点，newHead是后一个节点，对它们进行交换
        ListNode newHead =  head.next;
        newHead.next = head;
        //交换完成head已经成为第二个节点，指向递归出栈的节点（即后面两个节点交换完成的第一个节点）
        head.next = result;
        //返回交换完的第一个节点
        return newHead;
    }
}
