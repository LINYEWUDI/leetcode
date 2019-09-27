import java.util.ArrayList;
import java.util.List;

public class day15 {

  public static void main(String[] args) {
    int [] arr = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum(arr);
    for (List<Integer> list : lists){
      list.stream().forEach(System.out::println);
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    ArrayList<Integer> list= new ArrayList<>();
    ArrayList<List<Integer>> arrayList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length-2; j++) {
        for (int k = j; k < 2; k++) {
          boolean aTrue = isTrue(i, j, k);
          if (aTrue){
            arrayList = new ArrayList<>();
            list.add(i);
            list.add(j);
            list.add(k);
          }
        }
      }
      arrayList.add(list);
    }

    return arrayList;
  }



  public static boolean isTrue(int i,int j, int k) {
    if ((i + j + k) == 0){
      return true;
    }else {
      return false;
    }
  }


}
