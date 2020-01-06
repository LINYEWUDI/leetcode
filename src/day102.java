import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 层次遍历
 */
public class day102 {

  //初始化返回集合
  static LinkedList<List<Integer>> list = new LinkedList<>();

  public static void main(String[] args) {

    TreeNode treeNode = TreeUtils.createTreeNode();
    final LinkedList<List<Integer>> lists = levelOrderQueen(treeNode);
    System.out.println(lists);
  }

  /**
   * 队列实现
   */
  private static LinkedList<List<Integer>> levelOrderQueen(TreeNode treeNode) {

    //初始化队列装载每次遍历的节点左右子树和弹出该节点
    final Queue<TreeNode> queen = new LinkedList<>();

    //装载根节点
    queen.add(treeNode);


    int level = 0;
    while (queen.size() != 0){

      list.add(new ArrayList<>());
      final int size = queen.size();

      for (int i = 0; i < size; i++) {
        final TreeNode node = queen.remove();
        list.get(level).add(node.val);


        if (node.left != null) queen.add(node.left);
        if (node.right != null) queen.add(node.right);
      }

      ++level;

    }

    return list;

  }


  /**
   * 递归实现
   * @param treeNode
   * @param level
   * @return
   */
  private static LinkedList<List<Integer>> levelOrder(TreeNode treeNode,int level) {

    if (treeNode == null){
      return null;
    }

    List<Integer> innerList = new LinkedList<>();

    //当递归层数和返回集合相等时
    if (level == list.size()){

      innerList = new LinkedList<>();
      innerList.add(treeNode.val);
      //每层递归开始时就初始化集合并填入
      list.add(innerList);
    }else {
      innerList = list.get(level);
      innerList.add(treeNode.val);
    }


    levelOrder(treeNode.left,level+1);
    levelOrder(treeNode.right,level+1);


    return list;

  }


}
