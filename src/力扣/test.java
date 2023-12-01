import java.util.HashMap;
import java.util.Map;

public class test {
}
/**
 * 双向链表：
 * 按照被使用的顺序存储键值对
 * 自己实现一个简易的双向链表，用于存储key，value.需要有虚拟头/尾节点
 * 靠近头部的是最近使用的，尾部的是最久未使用的
 * hashmap：
 * 存储缓存中键值对及其位置
 */
class LRUCache1 {
    /**
     * 创建双向链表
     */
   class DLinkedNode{
       int key;
       int value;
       DLinkedNode pre;
       DLinkedNode next;
       public DLinkedNode(){}
       public DLinkedNode(int key,int value){
           this.key = key;
           this.value = value;
       }
   }
   //成员变量
    Map<Integer,DLinkedNode> cache = new HashMap<>();
   int size;
   int capacity;
   DLinkedNode head;
   DLinkedNode tail;

    /**
     * 初始化内存
     * @param capacity
     */
   public LRUCache1(int capacity){
       size = 0;
       this.capacity = capacity;
       head = new DLinkedNode();
       tail = new DLinkedNode();
       head.next = tail;
       tail.pre = head;
   }
   public int get(int key){
       DLinkedNode node = cache.get(key);
       if (node==null){return -1;}
       moveToHead(node);
       return node.value;

   }
   public void put(int key,int value){
       DLinkedNode node = cache.get(key);
       if (node==null){
           DLinkedNode newNode = new DLinkedNode(key,value);
           cache.put(key,newNode);
           addToHead(newNode);
           size++;
           if (size>capacity){
               DLinkedNode removeNode = removeTail();
               cache.remove(removeNode.key);
               size--;
           }
       }else {
           node.value = value;
           moveToHead(node);
       }
   }

   public void addToHead(DLinkedNode node){
       node.pre = head;
       node.next = head.next;
       head.next.pre  = node;
       head.next = node;

   }

    private void moveToHead(DLinkedNode node) {
      removeNode(node);
      addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
       node.next.pre = node.pre;
       node.pre.next = node.next;
    }
    private DLinkedNode removeTail(){
       DLinkedNode res = tail.pre;
       removeNode(tail.pre);
       return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */