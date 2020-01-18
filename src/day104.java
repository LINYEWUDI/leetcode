/**
 * 查询树的最大深度
 */
public class day104 {
  /**
   * 这题有些特殊，查询二叉树的最大深度，不是很适用于套路。
   * 目的是查询最大深度，无非就是看根节点的左右子树哪个更大一点，取大的那个再加一就是的，如果是为null则返回0即可
   */
  public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createTreeNode();
        System.out.println(findDeep(treeNode));

    }





    public static int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int left = maxDepth(root.left);
      int right = maxDepth(root.right);


      return (left > right ? left : right) + 1;


    }



















      public static Integer findDeep(TreeNode treeNode) {
        if (treeNode == null){
          return 0;
        }
        Integer leftDeep = findDeep(treeNode.left);
        Integer rightDeep = findDeep(treeNode.right);

        return Math.max(leftDeep,rightDeep)+1;
      }


    }




























