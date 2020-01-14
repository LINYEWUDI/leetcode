import java.util.ArrayList;
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
    System.out.println(digui(5));
  }


  public static List<List<Integer>> digui(int numRows) {
    List<List<Integer>> outList = new ArrayList<>();

    List<Integer> innerList = new ArrayList<>();

    outList.add(innerList);

    //出口
    if (numRows == 0){
      return outList;
    }

    if (numRows == 1){
      innerList.add(1);
      outList.add(innerList);
      return outList;
    }

    outList = digui(numRows-1);

    innerList.add(1);
    for (int i = 1; i < numRows; i++) {
      Integer num = outList.get(numRows-1).get(i-1) + outList.get(numRows-1).get(i);
      innerList.add(num);
    }
    innerList.add(1);

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
