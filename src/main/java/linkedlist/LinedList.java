package linkedlist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 链表的种类：单向链表，双向链表，循环链表，静态链表
 *
 * 链条操作：创建create，添加、删除；正向遍历和反向遍历、链表排序、判断链表是否有环isCircus、是否相交、获取某一结点等。
 * https://www.cnblogs.com/bjh1117/p/8335108.html
 */


public class LinedList {//1->2->3

    //单向链表
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }

    //双向链表
    class Node2 {
        int value;
        Node2 next;
        Node2 pre;

        public Node2(int value) {
            this.value = value;
        }

        public void setNext(Node2 node) {
            this.next = node;
        }

        public Node2 getNext() {
            return this.next;
        }

        public void setPre(Node2 node) {
            this.pre = node;
        }

        public Node2 getPre() {
            return this.pre;
        }
    }

    /**
     * 反转单向链表：递归法
     */
    public Node reverse(Node head) {

        /*
        temp 2, head 1, reverce/2, 2->1, 1->null
        temp 3,head 2, reverce/3, 3->2, 2->null
        return head/3
        */

        if (head == null || head.next == null) return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转单向链表：遍历法
     */
    public Node reverseV2(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            if (head.next != null) {
                next = head.next;
                pre = head;
                head = next;
                head.next = pre;
            }
        }
        return head;
    }

    /**
     * 链表是否有环：
     * 方法：穷举算法O(N*N)，哈希表算法O(N)，快慢指针O(N)，Set集合O(N)
     * * * START
     */
    public boolean isCircus(Node node) {//快慢指针
        if (node == null || node.next == null) return false;

        Node node1 = node.next;
        Node node2 = node.next.next;

        while (node2 != null) {
            if (node1 == node2) break;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if (node2 != null) return true;
        return false;
    }

    /**
     * 哈希表
     *
     * @param node
     * @return
     */
    public boolean isCircusV2(Node node) {
        Node current = node;
        HashSet<Node> nodes = null;
        while (current != null) {
            if (nodes.add(current) == false) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 创建链表，递归法
     *
     * @param arr
     * @return https://blog.csdn.net/IManiy/article/details/81628870
     */
    public static Node create(ArrayList<Integer> arr) {
        if (arr.isEmpty()) return null;

        Node firstNode = new Node(arr.get(0));
        System.out.println(arr.get(0));
        firstNode.setNext(create((ArrayList<Integer>) arr.subList(1, arr.size())));
        return firstNode;
    }

    /**
     * 俩链表是否相交
     *
     * @param head1,head2
     */
    public boolean isCrossing(Node head1, Node head2) {
        //空链表
        if (head1 == null || head2 == null) return false;

        if (!isCircus(head1) && !isCircus(head2)) {//俩链表均无环
            Node temp = head1;
            while (temp != null) {
                if (temp.next == null) {
                    temp.setNext(head2);
                } else {
                    temp = temp.getNext();
                }
            }
            return isCircus(head1);
        }

        //俩链表有环
        return false;
    }

    public static void main(String args[]) {
        //创建单链表
        List list = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.addAll(list);
        create(arr);
    }
}
