public class TreeUtils {

  //构造树
  public static TreeNode createTreeNode(){
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);

    treeNode1.left=treeNode2;
    treeNode1.right=treeNode3;

    treeNode2.left=treeNode4;
    treeNode2.right=treeNode5;

    treeNode3.left=treeNode6;
    treeNode3.right=treeNode7;

    return treeNode1;
  }
}
