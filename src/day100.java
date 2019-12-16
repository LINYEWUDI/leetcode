/**
 * 纪念一下我第二个递归。。。。虽然实在是太简单了。。。
 * 100题，相同的树。判断两个数上的节点是否完全相等
 */
public class day100 {
  /**
   * 思考：当做非递归来写，当比较两个树都是null时，那自然为true
   * 一个为null一个不为null时，返回false，因为两个子树都不对称，那肯定不行
   * 最后判断值是否一致
   * 综上为判断两个节点，此时将其推广
   * 将比较两个树的左子树和右子树分别进行比较
   */

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null){
      return true;
    }


    if (p == null || q == null){
      return false;
    }

    if (p.val != q.val){
      return false;
    }

    boolean leftBoolean = isSameTree(p.left, q.left);
    boolean rightBoolean = isSameTree(p.right, q.right);

    return leftBoolean&rightBoolean;
  }
}
