import java.util.HashMap;

public class $0019$removeNthFromEnd {
    public static void main(String[] args) {
        ListNode head = removeNthFromEndTwoPointer($0203$RemoveLinkedListElements.genLinkedList(new int[]{1,2,3,4,5}), 5);
        $0203$RemoveLinkedListElements.printLinkedList(head);
    }

    /**
     * 一开始想到的方法，遍历一次并记录每个节点的序号，然后再根据序号去删除对应的元素，这样也只需要一次遍历
     * 1.首先添加一个真正的头节点，方便删除第一个节点时的操作
     * 2.用一个指针指向头节点
     * 3.遍历链表，并记录在一个hashmap中，用序号作为key,节点作为value（其实本质上是用数组记录，但直接用数组记录不方便确定数组的长度）
     * 4.根据序号查找对应的节点并删除
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEnd(ListNode head, int n){
        //创建头节点
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode realHead = new ListNode(), p = realHead;
        realHead.next = head;
        Integer i = 0;
        //遍历链表，并存储在map中，因为实际上要找的是被删除元素的前一个元素，所以最后一个元素可以不放入map中
        while (p.next != null){
            map.put(i, p);
            p = p.next;
            i++;
        }
        //根据序号找到被删除元素的前一个元素，并进行删除操作
        map.get(i - n).next = map.get(i - n).next.next;
        return realHead.next;
    }

    /**
     * 双指针法：看题解得到的方法，可以在遍历一次的情况下用O(1)的空间复杂度解决问题，本质上是找到与末尾相距n个节点的位置
     * 1.还是添加一个头节点
     * 2.用快指针指向第一个节点，慢指针指向头节点
     * 3.将快指针往前移动n次，此时快慢指针之间就是一处跨越n个节点的区间
     * 4.同时移动快慢指针，直到快指针超出链表
     * 5.此时慢指针所指的位置就是要删除节点的前一个
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEndTwoPointer(ListNode head, int n){
        //头节点
        ListNode realHead = new ListNode();
        realHead.next = head;
        //创建快慢指针
        ListNode fast = head, slow = realHead;
        //快指针向前移动，因为题目中给出了n的取值范围，所以不用考虑NPE的问题
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //同时移动快慢指针，直到快指针超出范围
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //删除节点
        slow.next = slow.next.next;
        return realHead.next;
    }
}
