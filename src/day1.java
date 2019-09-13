import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class day1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    @Test
   public int[] show(int[] nums, int target) {
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

}
