import java.util.LinkedList;

/**
 * 反转一个单链表。
    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
 */
public class day206 {

  public static void main(String[] args) {
    ListNode lian = ListNodeUtils.createLian();
    ListNode listNode = digui(lian);
    ListNodeUtils.printLian(listNode);



  }

  /**
   *
   */
  public static ListNode digui(ListNode head) {
    //出口
    if (head == null || head.next == null){
      return head;
    }

    ListNode node = digui(head.next);

    //本次操作
    head.next.next = head;
    head.next = null;
    return node;

  }


  /**
   * 队列法
   */
    public static ListNode force(ListNode head) {
      ListNode node = head;

      LinkedList<ListNode> listNodes = new LinkedList<>();

      if (head == null){
        return null;
      }

      if (head.next == null){
        return head;
      }

      while (node != null){
        listNodes.add(node);
        node = node.next;
      }

      for (ListNode listNode : listNodes) {
        listNode.next = null;
      }

      ListNode listNode = listNodes.get(listNodes.size()-1);
      ListNode node1 = listNode;
      for (int i = listNodes.size()-1; i > 0; i--) {
        ListNode lastNode = listNodes.get(i - 1);
        node1.next = lastNode;
        node1 = node1.next;
      }

      return listNode;

    }
}
