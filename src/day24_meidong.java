/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class day24_meidong {

    public static void main(String[] args) {
      final ListNode lian = ListNodeUtils.createLian();
      final ListNode listNode = swapPairs(lian);
    }
    /**
     * 思想：第一次写递归思想,个人理解：
     * 套路分成三步：
     * 1.确定出口：该算法首先需要明确若节点为偶数则出口为最后一个节点的next为null，
     * 奇数则本节点为null
     * 2.思考返回的参数,根据题意理解为返回已经交换完成的节点
     * 3.确认方法中需要做的操作,首先取到头结点的下一个节点,然后将头结点的指针指向==》已经交换完成后的节点，最后将下一个节点的指针域指向头结点
     */
    public static ListNode swapPairs(ListNode head) {
        //出口
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;

    }
}


