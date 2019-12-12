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

    public static void main(String[] args) {
      TreeNode treeNode = null;
      System.out.println(minDepth(treeNode));
    }


    public static int minDepth(TreeNode root) {
      if (root == null) return 0;
      if (root != null){
        //定出口
        if (root.left == null && root.right == null){
          return 1;
        }
      }else {
        return 0;
      }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth,rightDepth)+1;
    }


}
