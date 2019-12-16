/**
 *给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
*/

public class day101 {
  /**
   * 思考：该题首先需要考虑到一个问题，递归的目的是判断两个节点是否相等，那么给出的递归方法需要有两个入参
   * 然后依旧是考虑不是递归的情况 正常给出一个二叉树，判断是否镜像，考虑特殊情况，没有任何节点直接返回true
   * 否则调用两个入参的方法，首先判断左右子树是否都为null，若都为null则认为只有一个节点，返回true，
   * 如果一个不为null一个为null，则肯定不是镜像的返回false
   * 如果两个节点的值不同，那么肯定不是镜像的，返回false
   * 到此，所有判断完毕，开始思考递归怎么写，假如上面两个树分别叫t1和t2
   * 再判断出t1的左和t2的右，t1的右和t2的左是否满足，就可以了
   *
   */
  public static void main(String[] args) {

    TreeNode treeNode = TreeUtils.createTreeNode();
    boolean symmetric = isSymmetric(treeNode);
    System.out.println(symmetric);
  }


  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    else return show(root.left,root.right);
  }



  public static boolean show(TreeNode t1,TreeNode t2) {

    if (t1 == null && t2 == null){
      return true;
    }


    if (t1 == null || t2 == null){
      return false;
    }

    if (t1.val != t2.val) return false;

    boolean show = show(t1.left, t2.right);
    boolean show1 = show(t1.right, t2.left);

    return show && show1;


  }
}
