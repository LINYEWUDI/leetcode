import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 自顶向下层次遍历
 */
public class day107 {
    static List<List<Integer>> list = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createTreeNode();
        System.out.println(levelOrderBottom(treeNode));

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return Collections.EMPTY_LIST;
        }
        return DFS(root,0);
    }

    public static List<List<Integer>> DFS(TreeNode treeNode,int level) {
        if (level == list.size()){
            list.add(new ArrayList<>());
        }

        list.get(level).add(treeNode.val);

        if (treeNode.left != null){
            DFS(treeNode.left,level+1);
        }

        if (treeNode.right != null){
            DFS(treeNode.right,level+1);
        }

        return list;
    }
}
