/**
  *  给定一个二叉树，判断它是否是高度平衡的二叉树。
  *      本题中，一棵高度平衡二叉树定义为：
  *      一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
  *      给定二叉树 [3,9,20,null,null,15,7]
  *
  *       3
  *      / \
  *     9  20
  *       /  \
  *      15   7
  */

public class day110 {

    public VO isBalanced(TreeNode root) {
      //出口
      if (root == null){
          return new VO(0,true);
      }

      if (isBalanced(root.left).isBST == false){
          return new VO(0,false);
      }
      if (isBalanced(root.right).isBST == false){
          return new VO(0,false);
      }
      if (Math.abs(isBalanced(root.left).high-isBalanced(root.right).high) > 1){
        return new VO(0,false);
      }

      return new VO(Math.max(isBalanced(root.left).high,isBalanced(root.right).high)+1,true);

    }



}

class VO{
    int high;
    boolean isBST;

    public VO(int high, boolean BST) {
        this.high = high;
        this.isBST = BST;
    }
}
