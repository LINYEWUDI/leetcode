import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class day1 {
    /**
     * 题目：
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

  public static void main(String[] args) {
    int []arr = {3, 2, 4};
    int target = 6;
    int[] show = show2(arr, target);

    for (int i = 0; i < show.length; i++) {
      System.out.println(show[i]);
    }
  }


  /**
   *   暴力解法
   *   思想：因为题目给出目标值,我们需要从数组中寻找两个值的和 等于 目标值
   *   所以两层循环依次拿到每个数组，相加进行判断，若相等时则保存两个值的下标，
   *   最后放进数组中
   */
   public static int[] show(int[] nums, int target) {
        int[] ints = {};
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                }
            }
        }
        ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

  /**
   * 使用hashmap
   * 思想：首先将所有数组中的值保存在hashmap中,
   * 然后用目标值-每一个hashmap中的值,然后判断差值是否在hashmap中存在,
   * 如果存在且不是本身,则构件数组返回
   */
  public static int[] show1(int[] nums, int target) {
    //将数组中的值都保存进hashmap中
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(nums[i],i);
    }

    for (int i = 0; i < hashMap.size(); i++) {
      //获取目标值-之前数组中每一个保存在hashmap中的数据
      Integer integer = hashMap.get(target - nums[i]);//这里的integer是坐标
      if (integer != null && integer != i){
        return new int[]{i,integer};
      }
    }
    return null;
  }

  /**
   * 使用hashmap一次for循环完成
   * 思想:初始化hashmap后直接遍历查找，若发现目标值-遍历值  在hashmap中存在
   * 则直接返回，若不存在，则添加本次遍历的值，重复该循环
   */
  public static int[] show2(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      Integer integer = hashMap.get(target - nums[i]);
      if (integer != null && i != integer){
        return new int[]{i,integer};
      }
      hashMap.put(nums[i],i);
    }
    return null;
  }



}
