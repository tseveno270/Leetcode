package 力扣;
/**
 * @author 270
 */
public class solution_21 {
    public static void main(String[] args) {


    }
}
class Solution21 {
    /**
     * 1.当有链表为空时，返回另一个
     * 2.当链表不为空时，如果l1.val<l2.val
     *   可以确定合并链表第一个节点为l1，然后l1.next通过递归获取，最后返回l1
     * 3.不满足时，递归l2，返回l2
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 ==null)return list2;
       else if (list2 ==null)return list1;
       else if (list1.val> list2.val){
           list2.next = mergeTwoLists(list1, list2.next);
           return list2;
       }
       else {
           list1.next = mergeTwoLists(list1.next, list2);
           return list1;
       }


    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
      if (list1==null){
          return list2;
      }else if (list2==null){
          return list1;
      }else if(list1.val<list2.val){
          list1.next = mergeTwoLists(list1.next,list2);
          return list1;
      }else{
          list2.next = mergeTwoLists(list1,list2.next);
          return list2;
      }
    }
}


