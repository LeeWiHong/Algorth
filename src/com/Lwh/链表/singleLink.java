/*
    单链表的基本操作
 */

package com.Lwh.链表;

public class singleLink {
    public static void main(String[] args) {
        orderLink link = new orderLink();
        dataNode dataNode1 = new dataNode("赵云1");
        dataNode dataNode2 = new dataNode("赵云2");
        dataNode dataNode3 = new dataNode("赵云3");
        dataNode dataNode4 = new dataNode("赵云4");
        dataNode dataNode5 = new dataNode("赵云5");
        link.addNode(dataNode1);
        link.addNode(dataNode2);
        link.addNode(dataNode3);
        link.addNode(dataNode4);
        link.addNode(dataNode5);

        orderLink link2 = new orderLink();

        dataNode dataNode6 = new dataNode("赵云6");
        dataNode dataNode7 = new dataNode("赵云7");

        link2.addNode(dataNode4);
        link2.addNode(dataNode6);
//        link2.addNode(dataNode5);

        System.out.println("---------------------------------------------");
//        link.reverseLink();
        link.displayLink();
        System.out.println("---------------------------------------------");

        link2.displayLink();
        System.out.println(orderLink.isCrossLink(link,link2));


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
    void addNode(dataNode node){

        if (head == null){
            head = node;
        }else
        {
            dataNode p = head;
            while (p.nextNode != null){
                p = p.nextNode;
            }
            p.nextNode = node;
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
        dataNode pre = null;
        dataNode current = head;
        dataNode next = head;
        while (next != null){
            next = current.nextNode;
            current.nextNode = pre;
            pre = current;
            if (next != null){
                current = next;
            }
        }
        this.head = current;
    }
    // 9.判断单链表有环
    boolean isCircleLink(){
        dataNode p1 = head;
        dataNode p2 = head;
        while (p2 != null){
            // 当next.next都是null的时候就已经不可能还存在环了
            if (p2.nextNode != null){
                p2 = p2.nextNode.nextNode;
                p1 = p1.nextNode;
                if (p1 == p2){
                    return true;
                }
            }else
            {
                return false;
            }
        }
        return false;
    }
    // 10.判断两条单链表是否相交
    static boolean isCrossLink(orderLink link1,orderLink link2){

        Integer lenA = link1.getLinkSize();
        Integer lenB = link2.getLinkSize();
        orderLink maxLink = lenA >= lenB?link1:link2;
        orderLink minLink = lenA <  lenB?link1:link2;

        Integer step = 0;
        Integer substep = lenA >= lenB ? (lenA - lenB):(lenB - lenA);
        dataNode pmaxNode = maxLink.head;
        dataNode pminNode = minLink.head;
        while (step < substep){
            pmaxNode = pmaxNode.nextNode;
            step = step + 1;
        }
        while (pmaxNode != null && pminNode != null){
            if (pmaxNode == pminNode){
                return true;
            }else {
                pmaxNode = pmaxNode.nextNode;
                pminNode = pminNode.nextNode;
            }
        }
        return false;
    }
    // 11.返回倒数第K个结点的值
//    dataNode returnReverseKNode(Integer k){
//        dataNode p1 = head;
//        dataNode p2 = p1;
//        Integer step = 0;
//        while (step < k){
//            p1 = p1.nextNode;
//            step ++;
//        }
//
//
//
//    }


}

