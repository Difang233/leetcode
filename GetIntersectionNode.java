import java.util.HashSet;

/**
 * 面试题02.07 链表相交
 */
public class GetIntersectionNode {
    /**
     * 最简单的想法，但是达不到题目要求的O(1)空间复杂度
     * 1.用一个hashset存储链表A的所有节点（因为链表没有环）
     * 2.遍历链表B，判断在hashset中能否找到同样的节点，如果有返回该节点，如果没有返回null
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m)
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode p = headA;
        while (p != null){
            listNodes.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null){
            if (listNodes.contains(p)){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 这个是根据官方题解写的，能够满足空间复杂度的要求，基本思路是同时移动两个指针，当两个指针指向的元素相等时就返回该元素，不过算法设计得很巧妙
     * 1.用指针pa和pb分别指向headA和headB
     * 2.同时移动两个指针
     * 3.当一个指针指向null而另外一个不为null时，将指向null的指针指向另一个链表
     * 4.当两个指针相等时返回该节点
     * 5.当两个指针都为空时，结束循环，返回null
     * 对于两个相交的链表，假设不相交的长度分别为a和b，相交的长度为c
     * 如果a == b，显然同时移动两个指针就可以找到相交的节点
     * 如果a != b，这个算法可以让每个指针都移动a+b+c次之后指向相交的节点
     * 对于不相交的链表，两个指针移动长度之和后都指向null
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        ListNode pa = headA, pb = headB;
        while (pa != null || pb != null){
            if (pa == pb){
                return pa;
            }
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return null;
    }
}
