package MyThink.ordersuanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderByOrder {

  public static void main(String[] args) {
    int[] arr = new int[]{50, 90, 8, 1, 5,3,2,1};
    quickSort(arr,0,arr.length-1);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  //快排
  public static void quickSort(int[] arr,int left,int right) {
    if (left < right){
      int middle = onceSort(arr,left ,right);
      quickSort(arr,left,middle-1);
      quickSort(arr,middle+1,right);
    }


  }

  //快排一次 实际上这个方法只有一个目的  就是将比 key小的放在左边 大的放在右边
  private static int onceSort(int[] arr, int left, int right) {
    int key = arr[left];
    //两个哨兵没有相遇
    while (left < right) {
      while (left < right && key <= arr[right]) {
        right--;
      }
      //当上一个循环结束时，则认为是出现了左边 > 右边
      arr[left] = arr[right];

      while (left < right && key >= arr[left]) {
        left++;
      }
      //当上一个循环结束时，则认为是出现了左边 > 右边
      arr[right] = arr[left];
    }

    arr[left] = key;
    return left;

  }

  //插入排序
  public static void charu(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int cur = arr[i + 1];
      int num = i;

      while (num >= 0 && arr[num] > cur) {
        arr[num + 1] = arr[num];
        num--;
      }

      arr[num + 1] = cur;
    }
  }

  //选择排序  稳定   n²
  public static void xuanze(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      //假设第一个就是最小的
      int max = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          max = j;//保存这个最小的数字，下面会进行交换
        }
      }
      int temp = arr[i];
      arr[i] = arr[max];
      arr[max] = temp;
    }
  }

  //冒泡排序  稳定   n²
  public static void maoPao(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;

        }
      }
    }
  }

}
