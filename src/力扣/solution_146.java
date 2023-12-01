import java.util.HashMap;
import java.util.Map;

public class solution_146 {
}

/**
 * 双向链表：
 * 按照被使用的顺序存储键值对
 * 自己实现一个简易的双向链表，用于存储key，value.需要有虚拟头/尾节点
 * 靠近头部的是最近使用的，尾部的是最久未使用的
 * hashmap：
 * 存储缓存中键值对及其位置
 */
class LRUCache {
    /**
     * 创建双向链表
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //声明成员变量

     Map<Integer,DLinkedNode> cache = new HashMap<>();
     //size表示当前缓存长度
     int size;
     int capacity;
     DLinkedNode head;
     DLinkedNode tail;


    public LRUCache(int capacity) {
        //初始化时缓存为空
        int size = 0;
        this.capacity = capacity;
        //初始化只有虚拟节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        //key不存在
        if (node==null){return -1;}
        //key存在,将node移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //如果key不存在，创建新节点
        if (node==null){
            //【注意！！！！】这里不能写new DLinkedNode()而要写DLinkedNode(key,value)。因为构造方法中有无参的
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            //添加到头部
            addToHead(newNode);
            size++;
            if (size>capacity){
                //如果超出容量,删除尾部节点
                DLinkedNode tail = removeTail();
                //同时删除哈希表中尾节点对应的项
                cache.remove(tail.key);
                size--;
            }
        }else{
            //如果节点存在，定位，然后修改其value
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 移动到双向链表头节点
     * @param node
     */
    public void moveToHead(DLinkedNode node){
        //删除节点
        removeNode(node);
        //添加节点
        addToHead(node);
    }

    /**
     * 头节点插入
     * @param node
     */
    public void addToHead(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 删除节点
     * @param node
     */
    public void removeNode(DLinkedNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    /**
     * 删除尾节点并返回
     * @return
     */
    public DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        removeNode(tail.pre);
        return res;
    }
}



