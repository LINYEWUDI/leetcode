import java.util.*;

public class day239 {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(arr,3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[]{};
        }
        LinkedList<Integer> LinkedList = show(nums, k);
        int[] ints = new int[LinkedList.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = LinkedList.get(i);
        }
        return ints;
    }

    public static LinkedList<Integer> show(int[] nums, int k) {
        //初始化最大值集合
        LinkedList<Integer> maxList = new LinkedList<>();

        LinkedList<Integer> LinkedList = new LinkedList<>();
        //数组转成集合
        for (int i = 0; i < nums.length; i++) {
            LinkedList.add(nums[i]);
        }

        int flag = 1;
        int size = LinkedList.size();
        while (LinkedList.size() >= k){
            LinkedList<Integer> linkedList = cutLeftArr(LinkedList, k);
            Integer maxNumber = maxNumber(linkedList);
            maxList.add(maxNumber);
            //截取后n段
            int rightSize = size - flag;
            LinkedList<Integer> cutList = cutRightArr(LinkedList, rightSize);
            LinkedList = cutList;
            flag++;
        }
        return maxList;
    }

    /**
     * 截取后n段
     */
    private static LinkedList<Integer> cutRightArr(List<Integer> list, int n){
        //前size位不需要
        int size = list.size() - n;

        LinkedList<Integer> listCut = new LinkedList<>();
        for (int i = size; i < list.size(); i++) {
            listCut.add(list.get(i));
        }
        return listCut;
    }


    /**
     * 截取前K位段
     */
    private static LinkedList<Integer> cutLeftArr(List<Integer> list,int k){
        LinkedList<Integer> listCut = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            listCut.add(list.get(i));
        }
        return listCut;
    }

    /**
     * 找到数组中最大数字
     */
    private static Integer maxNumber(LinkedList<Integer> list){
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>max){
                max = list.get(i);
            }
        }
        return max;
    }
}


