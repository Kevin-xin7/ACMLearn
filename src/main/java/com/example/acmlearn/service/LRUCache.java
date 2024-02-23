package com.example.acmlearn.service;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    //思路：
    //需要的东西:一个带头尾节点的双向链表来记录put进去的节点数据，一个Map来记录节点位置让查询能够O(1)
    // 空构造函数、key/value构造函数、头/尾节点、Class的初始化函数（包含capacity、size、head、tail的初始化）
    //put操作需要用到的步骤:
    // 先从map中get一下，如果存在，则更新value，并且将节点移动到头部;
    // 如果不存在，则new一个新的节点，赋值，放入map,size++,如果size > capacity,则删除尾部节点，并且将新节点添加到头节点
    //get操作:
    //从map中get,如果不存在，则直接返回-1;如果存在，则将节点移动到头部
    //总结:
    //需要的方法：
    //moveToHead、addToHead、remove、removeTail、get、put

    private class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode(){}
        public DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private DLinkNode head;
    private DLinkNode tail;
    private Map<Integer, DLinkNode> map = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.next = head;
    }

    public int get (int key){
        DLinkNode node = map.get(key);
        if(node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        DLinkNode node = map.get(key);
        if(node == null){
            DLinkNode newNode = new DLinkNode(key,value);
            addToHead(newNode);
            map.put(key,newNode);
            size++;
            if(size > capacity){
                DLinkNode removeNode = removeTail();
                map.remove(removeNode.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }

    }

    public void moveToHead(DLinkNode node){
        remove(node);
        addToHead(node);
    }

    public void addToHead(DLinkNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void remove(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DLinkNode removeTail(){
        DLinkNode node = tail.pre;
        remove(node);
        return node;
    }
}

