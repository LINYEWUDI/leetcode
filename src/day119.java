import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class day119 {


    public static List<List<Integer>> show(int rowIndex) {
      //每次初始化时都重新创建一个对象进行返回
      List<List<Integer>> outList = new LinkedList<>();

      //确定出口
      if (rowIndex == 0){
        return outList;
      }

      if (rowIndex == 1){
        List<Integer> innerList = new LinkedList<>();
        innerList.add(1);
        outList.add(innerList);
        return outList;
      }

      outList = show(rowIndex-1);

      //单次递归做的操作
      List<Integer> innerList = new LinkedList<>();
      innerList.add(1);
      for (int i = 1; i < rowIndex-1; i++) {//首尾都是1
        int num = outList.get(rowIndex-2).get(i) + outList.get(rowIndex-2).get(i-1);
        innerList.add(num);
      }
      innerList.add(1);
      outList.add(innerList);

      return outList;

    }


    public static List<Integer> getRow(int rowIndex) {
      List<Integer> list = show(rowIndex).get(rowIndex - 1);
      return list;
    }


  public static void main(String[] args) {
    List<Integer> row = getRow(5);
    System.out.println(row);
  }

}
