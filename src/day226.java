public class day226 {
  /**
   *翻转一棵二叉树。
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9

输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/
  public static void main(String[] args) {
    TreeNode treeNode = TreeUtils.createTreeNode();
    TraverseTree.isSymmetric(treeNode);
    System.out.println("====================");
    invertTree(treeNode);
    TraverseTree.isSymmetric(treeNode);
  }
  public static TreeNode invertTree(TreeNode root) {
    if (root.left == null && root.right == null){
      return root;
    }
    show(root,root);
    return root;
  }

  public static void show(TreeNode t1,TreeNode t2) {
    if (t1 == null || t2==null){
      return;
    }

    TreeNode treeNode = t1.right;
    t1.right = t2.left;
    t2.left = treeNode;

    show(t1.left,t2.left);
    show(t1.right,t2.right);
  }
}
