import java.util.*;

public class day15 {

  public static void main(String[] args) {
    int [] arr = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum1(arr);
    lists.stream().forEach(System.out::println);
  }

  /**
   *  双指针方法
   *  思想：首先进行排序,排序完成之后
   *  定义变量i从第一个数字开始向后遍历,然后初始化了两个指针,一个L指向该变量的后一个,一个R指向整个数组的最后一个
   *  排除不可能的情况：
   *  1.当nums[i]大于0时,而在i后的指针也一定大于0,所以不可能和为0
   *  2.如果i的下一个数字和i本身相同,则直接跳过本次判断,因为i相同肯定跟上一次结果一样
   *  3.判断三个数相加之后和是否为0,为0则将两个指针分别向左或者向右移动一步,同时判断指针和该指针的下一个是否是相同的,若相同则向后移动一格
   */
  public static List<List<Integer>> threeSum1(int[] nums) {
    int len = nums.length;
    //初始化返回集合
    ArrayList<List<Integer>> list = new ArrayList<>();

    if (len < 3){
      return list;
    }

    //数组排序
    Arrays.sort(nums);

    for (int i = 0; i < len; i++) {
      //如果起始数字已经大于0,那么相加和肯定不为0
      if (nums[i] > 0){
        break;
      }
      //如果后一个数和前一个数相同,则跳过
      if (i>0 && nums[i]==nums[i-1]){
        continue;
      }

      //初始化两个指针
      int L = i+1;
      int R = len-1;

      while (L < R){
        int sum = nums[i] + nums[L] + nums[R];
        LinkedList<Integer> integers = new LinkedList<>();
        if (sum == 0) {
          integers.add(nums[i]);
          integers.add(nums[L]);
          integers.add(nums[R]);
          list.add(integers);
          //碰到相等之后,两个指针分别向左或者向右移动一格
          while (L<R && nums[L]==nums[L+1]) L++;
          while (L<R && nums[R]==nums[R-1]) R--;

          L++;
          R--;
        }

        else if (sum > 0){
          R--;
        }
        else if (sum < 0){
          L++;
        }
      }
    }
    return list;
  }


  /**
   *  暴力方法
   *  思考：三数之和为0,首先控制数组中第一个数卡死,然后卡死第二个数,再让第三个数依次向后遍历
   *  第三个数遍历完之后,第二个数再往后走一步,第三个数再进行遍历,依次等第二个数遍历完成之后,第一个数往后走一步.
   *  依次判断第一 二 三个数之和是否为0
   *  若为0,则将三个数组成一个集合,再放入一个大集合中
   *
   *  检验重复：
   *  依次排序之后,进行去重
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          LinkedList<Integer> integers = new LinkedList<>();
          if ((nums[i] + nums[j] + nums[k]) == 0) {
            integers.add(nums[i]);
            integers.add(nums[j]);
            integers.add(nums[k]);
            Collections.sort(integers, new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                return o1 - o2;
              }
            });
            set.add(integers);
          }
        }
      }

    }
    ArrayList<List<Integer>> list = new ArrayList<>();
    list.addAll(set);
    return list;
  }
}
