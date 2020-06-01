public class ListNodeMiddleNode {

    public static void main(String[] args) {
        final ListNode listNode = ListNodeUtils.createLian();
        ListNodeUtils.printLian(listNode);
        final ListNode listNode1 = middleNode(listNode);
        System.out.println(listNode1.val);
    }

    /**
     * 寻找链表的中间节点
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return fast == null ? slow : slow.next;
    }
}
