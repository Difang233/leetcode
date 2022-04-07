import java.util.LinkedList;

public class $0203$RemoveLinkedListElements {
    public static void main(String[] args) {
        printLinkedList(removeElements(genLinkedList(new int[]{1,2,6,3,4,5,6}), 6));
        printLinkedList(removeElements(genLinkedList(new int[]{}), 1));
        printLinkedList(removeElements(genLinkedList(new int[]{7,7,7,7}), 7));
    }

    /**
     * 常规的遍历链表和删除节点的操作，因为没有头结点，所以可以手动增加一个头节点
     * 时间复杂度：O(n)
     * @param head
     * @param val
     * @return
     */
    static ListNode removeElements(ListNode head, int val){
        ListNode prevHead = new ListNode(0, head);
        ListNode cur = prevHead, next = prevHead.next;
        while (next != null){
            if (next.val == val){
                cur.next = next.next;
            }else {
                cur = cur.next;
            }
            next = next.next;
        }
        return prevHead.next;
    }

    public static ListNode genLinkedList(int[] nums){
        ListNode prevHead = new ListNode(0);
        ListNode cur = prevHead;
        for (int i = 0; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            cur.next = listNode;
            cur = listNode;
        }
        return prevHead.next;
    }

    public static void printLinkedList(ListNode head){
        LinkedList<Integer> integers = new LinkedList<>();
        while (head != null){
            integers.add(head.val);
            head = head.next;
        }
        System.out.println(integers);
    }
}

class ListNode{
    int val;

    ListNode next;

    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}