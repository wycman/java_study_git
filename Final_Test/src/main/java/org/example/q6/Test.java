package org.example.q6;

public class Test {
    public static void main(String[] args) {
        // 第一个链表：
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);

        list1.add(6);
        list1.add(3);
        list1.add(9);
        list1.add(-2);

        // 第一个链表的头结点：head1
        MyLinkedList.Node<Integer> head1 = list1.head;

        // 第二个链表：
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(4);
        list2.add(1);
        list2.add(3);
        // 第二个链表的头结点：head1
        MyLinkedList.Node<Integer> head2 = list2.head;
        System.out.println("********排序前:");
        System.out.println("list1：");
        list1.print();
        System.out.println("list2：");
        list2.print();
        // 功能1：在MyLinkedList类中，开发一个sort方法，对两个链表分别排序，并分别遍历输出
        System.out.println("********排序后:");
        sort(head1);
        sort(head2);
        System.out.println("list1：");
        list1.print();
        System.out.println("list2: ");
        list2.print();
        // 功能2：在MyLinkedList类中，开发一个mergeSort方法，支持将这两个升序排序的链表，合并成一个新链表，要求新链表中的节点仍然是递增排序的。
        // ，然后对新链表遍历输出
        System.out.println("list1和list2合并排序后:");
        MyLinkedList<Integer> myLinkedList = mergeSort(head1, head2);
        System.out.println("新的list:");
        myLinkedList.print();
    }


    //将一个链表中的所有元素按顺序从小到大排序
    public static void sort(MyLinkedList.Node<Integer> head){
        if(head == null || head.next == null)
            return;
        MyLinkedList.Node<Integer> p = head;
        while (p != null){
            MyLinkedList.Node<Integer> q = p.next;
            MyLinkedList.Node<Integer> temp_min_q = p;
            while (q != null) {
                if(q.data < temp_min_q.data){
                    temp_min_q = q;
                }
                q = q.next;
            }
            int temp = p.data;
            p.data = temp_min_q.data;
            temp_min_q.data = temp;
            p = p.next;
        }
    }

    //将两个升序排序的链表进行合并，并按顺序从小到大排序
    public static MyLinkedList<Integer> mergeSort(MyLinkedList.Node<Integer> head1, MyLinkedList.Node<Integer> head2){
        //p与q分别指向每个链表的头部
        MyLinkedList.Node<Integer> p = head1;
        MyLinkedList.Node<Integer> q = head2;
        //建立一个合并链表
        MyLinkedList<Integer> merge_list = new MyLinkedList<>();
        //k指向新链表的头部
        MyLinkedList.Node<Integer> c = merge_list.head;
        while (p != null && q != null){
            if(p.data > q.data){
                c = merge_list.add(q.data);
                q = q.next;
            }else {
                c = merge_list.add(p.data);
                p = p.next;
            }
        }
        while (p != null){
            c = merge_list.add(p.data);
            p = p.next;
        }
        while (q != null){
            c = merge_list.add(q.data);
            q = q.next;
        }
        return merge_list;
    }
}
