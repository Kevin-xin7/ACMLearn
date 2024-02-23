package com.example.acmlearn.service;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    //题目要求:手动实现O(1)的查询和添加的LRU缓存
    //思路：双向链表+hashmap
    //get put remove addToHead moveToHead removeTail
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
        public Node(){}
    }
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map = new HashMap<>();

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        //如果key不存在，返回-1;如果存在，则将节点移动到head后面
        Node node = map.get(key);
        if(node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        //如果key不存在，就创建新节点并addToHead,并且放入map;如果size>capacity,就removeTail，并将tail从map中remove掉
        //如果key存在,将将节点移动到head,并更新value
        Node node = map.get(key);
        if(node == null){
            Node newNode = new Node(key,value);
            addToHead(newNode);
            map.put(key,newNode);
            size++;
            if(size > capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }

    public Node removeTail(){
        Node node = tail.prev;
        remove(node);
        return node;
    }

}
