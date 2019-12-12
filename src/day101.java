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
  static int count = 0;
  public static void main(String[] args) {

    TreeNode treeNode = TreeUtils.createTreeNode();
    boolean symmetric = isSymmetric(treeNode);
    System.out.println(symmetric);
  }


  public static boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return isMirror(root, root);
  }

  public static boolean isMirror(TreeNode t1, TreeNode t2) {
    System.out.println(++count);
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
  }



}
