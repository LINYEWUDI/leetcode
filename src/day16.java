import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day16 {

  public static void main(String[] args) {
    int [] arr = {-1,2,1,-4};
    System.out.println(threeSumClosest(arr,1));
  }

  /**
   * 暴力方法
   */
  public static int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    ArrayList<List<Integer>> list = new ArrayList<>();
    //初始化和
    int sum = 0;
    //初始化第一个和减去目标值的差
    int min = (nums[0] + nums[1] + nums[2]) - target;

    for (int i = 1; i < len - 2; i++) {
      for (int j = i+1; j < len - 1; j++) {
        for (int k = j+1; k < len; k++) {
          sum = (nums[i] + nums[j] + nums[k]);
          if (Math.abs(sum - target) < min){
              min = Math.abs(sum - target);
          }
        }
      }
    }
  return min+target;
  }
}
