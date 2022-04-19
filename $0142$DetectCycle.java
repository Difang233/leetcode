import java.util.HashSet;

public class $0142$DetectCycle {

    /**
     * 遍历链表，将每个元素存储在一个hashset中，如果元素已经存在于hashset中，说明有环
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode p = head;
        while (p != null){
            if (listNodes.contains(p)){
                return p;
            }
            listNodes.add(p);
            p = p.next;
        }
        return null;
    }

    /**
     * 看题解得到的双指针法：
     * 1.用两个指针fast和slow从头开始遍历链表，fast移动两个元素，slow移动一个元素
     * 2.当两个指针指向同一个元素时，说明有环，设此时fast移动的距离是f,slow移动的距离是s，根据第一步可以得到 f = 2s，
     * 3.另外，假设链表在入环前的长度为a，slow指针入环后走过的长度为b，环中剩余的长度为c，可以得到 s = a + b, f = a + n(b+c) + b，其中n为fast指针在相遇前在环中走过的圈数
     * 4.根据第一、二步的等式可以得到,s = n(b+c)
     * 5.现在还需要找到a的值，因为当一个指针移动了 a + n(b+c) 次和移动了 a 次之后会指向相同的位置（因为b+c是环的长度），所以将fast指向链表的首元节点，同时移动fast和slow，当它们相遇时刚好走a次，所指元素即为入环元素
     * @param head
     * @return
     */
    static ListNode detectCycle2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
