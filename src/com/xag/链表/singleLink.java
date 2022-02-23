/*
    单链表的基本操作
 */

package com.xag.链表;

public class singleLink {
    public static void main(String[] args) {
        orderLink link = new orderLink();
        link.addNode("赵云1");
        link.addNode("赵云2");
        link.addNode("赵云3");
        link.addNode("赵云4");
        link.addNode("赵云5");
        link.addNode("赵云6");
        link.addNode("赵云7");
        link.addNode("赵云8");
        link.addNode("赵云9");
        link.addNode("赵云10");
        link.displayLink();
        System.out.println("----------------------------");
        link.deleteNode(10);
        link.displayLink();
        System.out.println(link.getLinkSize());
    }
}

class dataNode{
    String node;
    dataNode nextNode;
    dataNode(String node){
        this.node = node;
        nextNode = null;
    }
}

class orderLink{
    dataNode head;
    // 1.初始化链表
    orderLink(){
        head = null;
    }

    // 2.添加结点
    void addNode(String node){
        dataNode dataNode = new dataNode(node);
        if (head == null){
            head = dataNode;
        }else
        {
            dataNode p = head;
            while (p.nextNode != null){
                p = p.nextNode;
            }
            p.nextNode = dataNode;
        }
    }
    // 3.输出链表数据
    void displayLink(){
        dataNode p = head;
        while (p != null){
            System.out.println(p.node+"-------");
            p=p.nextNode;
        }
    }

    // 4.获取链表长度
    Integer getLinkSize(){
        dataNode p = head;
        Integer size = 0;
        while (p != null){
            size++;
            p = p.nextNode;
        }
        return size;
    }

    // 5.指定位置插入结点
    void insertNode(String node,Integer position){
        if (position < 0 || position > getLinkSize()){
            System.out.println("插入数据位置有错误");
            return;
        }

        dataNode dNode = new dataNode(node);
        dataNode p = head;

        // 如果是在头插入
        if (position == 0){
            head = dNode;
            dNode.nextNode = p;
        }else {
            // 如果是在中间或者结尾插入
            Integer size = 0;
            while (p != null){
                size = size + 1;
                if (size == position){
                    dNode.nextNode = p.nextNode;
                    p.nextNode = dNode;
                    return;
                }else
                {
                    p = p.nextNode;
                }
            }
        }
    }

    // 6.修改指定位置结点的值
    void modifyNode(String node,Integer position){
        if (position <= 0 || position > getLinkSize()){
            System.out.println("修改的位置有错误");
            return;
        }
        dataNode p = head;
        Integer size = 0;
        while (p != null){
            size = size + 1;
            if (size == position){
                p.node = node;
                return;
            }else
            {
                p = p.nextNode;
            }
        }

    }

    // 7.删除指定位置结点
    void deleteNode(Integer position){
        if (position <= 0 || position > getLinkSize()){
            System.out.println("删除的指定位置有错误");
            return;
        }
        // 单链表的删除需要两个指针
        dataNode p = head;
        dataNode q = p;
        // 如果是要删除头结点
        if (position == 1){
            head = p.nextNode;
            p = null;
            return;
        }

        Integer size = 1;
        while (p != null){
            size ++;
            p =  q.nextNode;
            if (position == size){
                q.nextNode = p.nextNode;
                p = null;
                return;
            }else {
                q = p;
                p = p.nextNode;
            }
        }
    }

    // 8.反转链表
    void reverseLink(){
        dataNode begin = head;
        dataNode mid = begin;
        dataNode end = begin;

        while (end != null){
            if (begin == head){
                begin.nextNode = null;
            }else {
                end = end.nextNode;
                mid = mid.nextNode;
            }
        }
        head = end;
    }

}

