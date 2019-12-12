public class TraverseTree {
  /**
   * 遍历树。。第一次写出来递归。。。
   * @param args
   */
  public static void main(String[] args) {
    TreeNode treeNode = TreeUtils.createTreeNode();
    isSymmetric(treeNode);
  }

  public static void isSymmetric(TreeNode root) {
    //确定出口
    if (root == null){
      return;
    }

    isSymmetric(root.left);
    isSymmetric(root.right);
    System.out.println(root.val);


  }

}
