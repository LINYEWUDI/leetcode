public class day19 {

 /**
  *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
  *   示例：
  *   给定一个链表: 1->2->3->4->5, 和 n = 2.
  *   当删除了倒数第二个节点后，链表变为 1->2->3->5.
  */

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 0;

    //初始化哑结点
    ListNode node = new ListNode(null);
    node.next = head;
    ListNode listNode = node;

    while (listNode != null){
      len++;
      listNode = listNode.next;
    }

    listNode = node;

    int location = len - n;

    for (int i = 0; i < location-1; i++) {
      listNode = listNode.next;
    }

    listNode.next = listNode.next.next;

    return node.next;

  }

  public static void main(String[] args) {
//     ListNode listNodeX1 = new ListNode(1);
//     ListNode listNodeX2 = new ListNode(2);
//     ListNode listNodeX3 = new ListNode(3);
//     ListNode listNodeX4 = new ListNode(4);
//     ListNode listNodeX5 = new ListNode(5);
//
//     listNodeX5.next = listNodeX4;
//     listNodeX4.next = listNodeX3;
//     listNodeX3.next = listNodeX2;
//     listNodeX2.next = listNodeX1;

    ListNode listNodeX1 = new ListNode(2);
    ListNode listNodeX2 = new ListNode(1);

    listNodeX2.next = listNodeX1;

    ListNode node = removeNthFromEnd(listNodeX2, 2);

    while (node != null){
      System.out.println(node.val);
      node = node.next;
    }
  }

}
