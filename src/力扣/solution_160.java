package 力扣;

public class solution_160 {
}

class Solution160 {
    /**
     * 链表尽量用虚拟头节点做变量和指针起点
     * 双指针，分别指向两个链表虚拟头节点
     * slow指向A并不动，B从头开始遍历，如果B==A那么返回B
     * 没有则A = A.NEXT;直到A==null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = new ListNode(0, headA);
        ListNode b = new ListNode(0, headB);
        ListNode temp = b;
        int flag = 0;
        if (a.next == null || b.next == null) return null;
        while (a.next!=null) {
            if (a.next == b.next) {
                flag = 1;
                break;
            }
            b = b.next;
            if (b.next == null) {
                b = temp;
                a = a.next;
            }
        }
        return flag == 1 ? a.next : null;
    }

    /**
     * 双指针，是这样的。指针分别两个链表起点开始走，遍历完A(B)链表再继续遍历B(A)链表
     * 那么从不同起点相当于走的相同顺序。假设链表和公共部分长度分别为a，b，c
     * 那么遍历到公共节点分别需要走a+b-c和b+a-c。也就是说走了相同的距离如果此时相等那么就相等。
     * 当公共链表长度c>0有节点，c=0没有公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = new ListNode(0,headA);
        ListNode b = new ListNode(0,headB);
        //这样在a和b遍历是总能走到null，而且循环多次后一定有一次都等于null
        //这样可以将不重合的情况也考虑在内
        while (a!=b){
            a = a!=null?a.next:headB;
            b = b!=null?b.next:headA;
        }
        return a;
    }
}
