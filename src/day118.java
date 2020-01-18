import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 杨辉三角
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class day118 {
  public static void main(String[] args) {
//    System.out.println(force(5));
    List<List<Integer>> digui = digui(5);

    System.out.println(digui);


  }


  public static List<List<Integer>> digui(int numRows) {
    List<List<Integer>> outList = new LinkedList<>();

    if (numRows == 0){
      return outList;
    }

    //出口
    if (numRows == 1){
      LinkedList<Integer> list = new LinkedList<>();
      list.add(1);
      outList.add(list);
      return outList;
    }

    outList = digui(numRows - 1);

    LinkedList<Integer> innerList = new LinkedList<>();
    innerList.add(1);
    //本次递归需要做的操作
    for (int j = 1; j < numRows-1; j++) {
      Integer num = outList.get(numRows-2).get(j) + outList.get(numRows-2).get(j-1);
      innerList.add(num);
    }
    innerList.add(1);

    outList.add(innerList);

    return outList;

  }


  /**
   * 动态规划
   */
  public static List<List<Integer>> dp(int numRows) {
    //确定状态  f(x,y) = 当前位置的数字
    int [][] arr = new int[5][5];

    //初始化状态
    for (int i = 0; i < numRows; i++) {
      arr[0][i] = 1;
    }

    for (int i = 0; i < numRows; i++) {
      arr[i][i] = 1;
    }

    //转移方程 f(x,y) = f(x-1,y-1)+f(x-1,y)
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[i].length; j++) {
        arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
      }
    }

    LinkedList<List<Integer>> outList = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {

      LinkedList<Integer> innerList = new LinkedList<>();

      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] != 0){
          innerList.addFirst(arr[i][j]);
        }
      }

      outList.add(innerList);
    }
    return outList;
  }



  public static List<List<Integer>> force(int numRows) {
    final ArrayList<List<Integer>> outerList = new ArrayList<>();

    //初始化
    for (int i = 0; i < numRows; i++) {
      final ArrayList<Integer> innerList = new ArrayList<>();

      for (int j = 0; j <= i; j++) {
        innerList.add(0);
      }

      int start = 0;
      int end = innerList.size()-1;

      innerList.set(start,1);
      innerList.set(end,1);

      outerList.add(innerList);
    }

    final List<List<Integer>> generate = generate(outerList);

    return generate;
  }

  public static List<List<Integer>> generate(List<List<Integer>> outlist) {
    for (int i = 2; i < outlist.size(); i++) {
      final List<Integer> innerList = outlist.get(i);

      for (int j = 1; j < innerList.size()-1; j++) {
        Integer num = outlist.get(i-1).get(j) + outlist.get(i-1).get(j-1);
        innerList.set(j,num);
      }
    }

    return outlist;

  }

}
