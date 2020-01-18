/**
 *您将获得一个双向链表，除了下一个和前一个指针之外，
 * 它还有一个子指针，可能指向单独的双向链表。
 * 这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，
 * 如下面的示例所示。
扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
示例:
输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class day430 {

  public static void main(String[] args) {
     Node node = new Node();
     Node node1 = new Node();
     Node node2 = new Node();
     Node node3 = new Node();
     Node node4 = new Node();
     Node node5 = new Node();

    node.val=1;
    node.next=node1;

    node1.val=2;
    node1.prev=node;
    node1.next = node2;
    node1.child = node3;

    node2.val = 3;
    node2.prev=node1;

    node3.val = 4;


    Node demo = new Node();
    demo = node;
    while (demo!=null){
      System.out.println(demo.val);
      demo = demo.next;
    }
    System.out.println("======================");

    flatten(node);
    
    while (node!=null){
      System.out.println(node.val);
      node = node.next;
    }


  }

  public static Node flatten(Node head) {
    Node node = head;

    while (node != null && node.next != null){
     Node temp = null;
      if (node.child != null){
        temp = node.next;
        node.next = node.child;
        Node child = node.child;
        child.prev = node;
        node.child = null;
      }

      node = node.next;

      if (node.next == null && temp != null){
        node.next = temp;
        temp.prev = node;
      }

    }

    return head;
  }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};