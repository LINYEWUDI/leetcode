/**
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
示例:
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 */
public class day111 {

  /**
   * 思考：看做一个非递归的题目(非无限)完成，求最少深度，那么当自身为null时，已经是叶子节点之下了，高度为0
   * 若左右子树都是null，则为叶子节点，高度为1
   * 左右子树有一个为空的情况为，则直接用左右子树深度和再加一，因为此时为有一个为null，则必有一个为0,例如： 3
                                                                                         \
                                                                                         20
                                                                                          \
                                                                                          7
   这种情况下，一层一层的看，递归最深处此时root为7，左右子树都是null，return 1，然后root为20，左子树为null，右子树有值，则此时为0+1+1=2
   此时到了3，依旧是左边为null，右边为2，0+2+1=3，也就是树的深度为3
   *
   */

    public static void main(String[] args) {
      TreeNode treeNode = TreeUtils.createTreeNode();
      System.out.println(minDepth(treeNode));
    }


    public static int minDepth(TreeNode root) {
      if (root == null) return 0;
      //定出口
      if (root.left == null && root.right == null){
        return 1;
      }

      int leftDepth = minDepth(root.left);
      int rightDepth = minDepth(root.right);

      if (root.left == null || root.right == null){
        return leftDepth+rightDepth+1;
      }
      return Math.min(leftDepth,rightDepth)+1;
    }


}
