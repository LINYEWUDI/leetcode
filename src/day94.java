import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class day94 {
  List<Integer> list  = new LinkedList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null){
      return list;
    }

    list.add(show(root));
    inorderTraversal(root.left);
    inorderTraversal(root.right);
    return list;
  }

  public Integer show(TreeNode root) {
    if (root == null){
      return null;
    }else {
      return root.val;
    }
  }

}
