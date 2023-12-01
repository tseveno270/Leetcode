import Sword_offer2.ListNode;

public class solution_82 {
}
class Solution82 {
    //遍历节点，将重复的都删除
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if (cur.next.val==cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
