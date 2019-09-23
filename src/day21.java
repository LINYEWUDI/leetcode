public class day21 {

  /**
   * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
   *
   * 示例：
   * 输入：1->2->4, 1->3->4
   * 输出：1->1->2->3->4->4
   */


  /**
   *  迭代
   */
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //初始化合并之后的链表
    ListNode pHead = new ListNode(0);
    ListNode pre = pHead;

    while (l1!=null && l2!=null){
        if (l1.val < l2.val){
          pHead.next = l1;
          l1 = l1.next;
        }else {
          pHead.next = l2;
          l2 = l2.next;
        }

      pHead = pHead.next;
    }

    pHead.next = l1 == null ? l2 : l1;

    return pre.next;
  }

  public static void main(String[] args) {
    ListNode listNodeX1 = new ListNode(4);
    ListNode listNodeX2 = new ListNode(2);
    ListNode listNodeX3 = new ListNode(1);

    listNodeX3.next = listNodeX2;
    listNodeX2.next = listNodeX1;


    ListNode listNodeY1 = new ListNode(4);
    ListNode listNodeY2 = new ListNode(3);
    ListNode listNodeY3 = new ListNode(1);

    listNodeY3.next = listNodeY2;
    listNodeY2.next = listNodeY1;

    ListNode listNode = mergeTwoLists(listNodeX3, listNodeY3);

    while (listNode.next!=null || listNode.val!=null){
      System.out.println(listNode.val);
      if (listNode.next!=null) listNode = listNode.next;
      else break;
    }
  }
}
