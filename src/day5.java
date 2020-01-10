/**
 *
 */

public class day5 {

    public static void main(String[] args) {
        String str = "aaaacababac";
        String str1 = "cbbd";
        String max = max(str);

      final String s = hwDp(str);
      System.out.println(s);

    }
    /**
     * 动态规划
     */
    private static String hwDp(String s){
      final int length = s.length();
      //确定状态---表格记录的值是什么
      final boolean[][] arr = new boolean[length][length];

      //初始化状态
      for (int i = 0; i < arr.length; i++) {
        arr[i][i] = true;
      }

      if (arr.length < 2){
        return s;
      }

      int start = 0;
      int len = 1;

      //转移方程  arr[i][j]=true  <====>  s[i]==s[j] && arr[i+1][j-1]
      for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = arr[i + 1][j - 1];
                    }
                } else {
                    arr[i][j] = false;
                }


          if (arr[i][j]){
            int curLen = j - i + 1;
            if (curLen > len){
              len = curLen;
              start = i;
            }
          }

        }

      }

      return s.substring(start,start+len);

    }



    /**
     * 暴力解决
     */
    public static String max(String str){

        int max = 0;
        int max1 = 0;
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                String substring = str.substring(i, j);
                boolean huiWen = isHuiWen(substring);
                if (huiWen){
                    max1 = max;
                    max = Math.max(max,substring.length());
                    if (max > max1){
                        s = substring;
                    }
                }
            }
        }
        return s;
    }
    //判断是否是回文
    public static boolean isHuiWen(String str){
        for (int i = 0; i < str.length()/2; i++) {
            char x = str.charAt(i);
            char c = str.charAt(str.length() - i - 1);

            if (x != c) return false;
        }

        return true;
    }
}