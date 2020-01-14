public class ListUtils {

  public static ListNode createLian(){
    final ListNode listNode = new ListNode(0);
    final ListNode listNode1 = new ListNode(2);
    final ListNode listNode2 = new ListNode(3);
    final ListNode listNode3 = new ListNode(4);

    listNode.next = listNode1;
    listNode1.next = listNode2;
    listNode2.next = listNode3;

    return listNode;
  }
}
