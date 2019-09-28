import java.util.*;

public class day15 {

  public static void main(String[] args) {
    int [] arr = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum(arr);
    lists.stream().forEach(System.out::println);
  }
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
