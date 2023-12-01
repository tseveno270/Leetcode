package Sword_offer2;

class MyLinkedList {
    //链表元素个数
    int size;
    //虚拟头节点
    ListNode dummy;
    //初始化链表
    public MyLinkedList() {
      size = 0;
      dummy = new ListNode(0,null);
    }

    //查询
    public int get(int index) {
        ListNode temp = dummy;
        if (index<0||index>=size){
            return -1;
        }
        for (int i = 0; i < index+1; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    //插入头节点
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val,dummy.next);
        dummy.next = temp;
        size++;
    }

    //插入尾节点
    public void addAtTail(int val) {
        ListNode  tail = new ListNode(val,null);
        ListNode temp = dummy;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode temp = dummy;
        ListNode add = new ListNode(val);
        if (index<0){
            addAtHead(val);
        }else if (index==size){
            addAtTail(val);
        }else if (index>=0&&index<size){
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            add.next = temp.next;
            temp.next = add;
            size++;
        }else {
            return;
        }
    }

    //删除指定节点
    public void deleteAtIndex(int index) {
        ListNode temp = dummy;
        if (index>=0&&index<size){
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }else {
            return;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
