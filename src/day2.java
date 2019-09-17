import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
 class ListNode {
      Integer val;
      ListNode next;
      ListNode(Integer x) { val = x; }
  }


public class day2 {

    /**
     *  自己解法(未通过原因未知)
     *  思想：拿到两个链表后,分别计算出链表所代表的值,然后相加,再重新生成链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化计数器
        Integer count1 = 1;
        Integer count2 = 1;

        Integer sum1 = 0;
        Integer sum2 = 0;

        /**
         * 判断链表还有没有下一个节点
         */
        while (l1.val != 0){
            //每向后一个节点乘10
            for (Integer i = 1; i < count1; i++) {
                l1.val = l1.val*10;
            }
            sum1 += l1.val;
            count1++;

            l1 = l1.next;

            if (l1 == null) break;
        }

        while (l2.val != 0){
            //每向后一个节点乘10
            for (Integer i = 1; i < count2; i++) {
                l2.val = l2.val*10;
            }
            sum2 += l2.val;
            count2++;

            l2 = l2.next;

            if (l2 == null) break;
        }

        long sum = sum1 + sum2;

        int count0 = 0;

        String str = String.valueOf(sum);
        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch != '0'){
                break;
            }else {
                count0 ++;
            }
        }
        int len = str.length();

        if (str.length() > 1) len = str.length() - count0;

        String substring = str.substring(0, len);

        List<ListNode> list = new ArrayList<>();

        ListNode listNode1 = null;

        for (int i = substring.length() -1 ;i >= 0; i--) {
            char ch = str.charAt(i);
            listNode1 = new ListNode(Integer.parseInt(String.valueOf(ch)));

            list.add(listNode1);
        }


        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1) break;
            list.get(i).next = list.get(i+1);
        }

        if (list.size() > 2)         list.get(list.size()-2).next = list.get(list.size()-1);

        ListNode listNode = list.get(0);

        return listNode;
    }

    /**
     * 进位解法
     * 思想：同时遍历两个链表,然后相加,每次保存进位的值,带入下一次的相加当中.
     * 最后从头结点返回的即为正确答案(同样也是逆向的)
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //创建头结点
        ListNode pre = new ListNode(0);
        //创建移动指针指向头结点
        ListNode t = pre;
        //初始化进位值
        int carry = 0;

        //节点不为空时
        while (l1 != null || l2 != null){
          int x = l1.val == null? 0:l1.val;
          int y = l2.val == null? 0:l2.val;

          //初始化总和
          int sum = x+y+carry;

        /**
         *  sum = 7+8 = 15
         *  carry = 1
         *  sum = 5
         *  carry为进位值,需要进行储存,带到下一次计算当中
         */

          //进位值
          carry = sum/10;
          //非进位值
          sum = sum%10;

          //初始化下一个节点为 和的个位数
          t.next = new ListNode(sum);
          //移动指针
          t = t.next;

          //如果两个链表都下一个都不为空时,移动指针
          if (l1 != null){
              l1 = l1.next;
          }
          if (l2 != null){
              l2 = l2.next;
          }
        }

        //当最后一位有进位时,创建最后一个节点进行
        if (carry == 1){
            t.next = new ListNode(carry);
        }
        return pre;
    }

    public static void main(String[] args) {
        /*  [9,9,9,9,9,9,9,9,9,9]
            [9,9,9,9,9,9,9,9,9,9]
         */
        ListNode listNodeX1 = new ListNode(9);
        ListNode listNodeX2 = new ListNode(9);
        ListNode listNodeX3 = new ListNode(9);

        listNodeX3.next = listNodeX2;
        listNodeX2.next = listNodeX1;


        ListNode listNodeY1 = new ListNode(9);
        ListNode listNodeY2 = new ListNode(9);
        ListNode listNodeY3 = new ListNode(9);

        listNodeY3.next = listNodeY2;
        listNodeY2.next = listNodeY1;

//        ListNode listNodeX3 = new ListNode(0);
//        ListNode listNodeY3 = new ListNode(0);



        ListNode listNode = addTwoNumbers1(listNodeX3, listNodeY3);


        while (listNode.next!=null || listNode.val!=null){
            System.out.println(listNode.val);
            if (listNode.next!=null) listNode = listNode.next;
            else break;
        }
    }



}
