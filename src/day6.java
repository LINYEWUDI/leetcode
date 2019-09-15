import java.util.ArrayList;

/**
 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 请你实现这个将字符串进行指定行数变换的函数：
 string convert(string s, int numRows);
 示例 1:
 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:
 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:
 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G
 */

public class day6 {

    public static void main(String[] args) {
        String convert = convert("PAYPALISHIRING", 3);
        System.out.println(convert);

    }

    public static String convert(String s, int numRows) {
        int len = (numRows*(s.length()/(2*numRows-1)))-1;
        String[][] arr = new String[numRows][len];
        ArrayList<Integer> list = new ArrayList<>();

        for (int k = 0; k < len; k++) {
            list.add( (numRows - 1)*k );
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //竖列满载
                if (j % (numRows-1) == 0) {
                    arr[i][j] = "1";
                }else {
                    arr[i][j] = "";
                }

                if (list.contains((i + j))) {
                    arr[i][j] = "1";
                }
            }
        }
        String[][] show = show(arr, s);

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                stringBuffer.append(show[i][j]);
            }
        }
        return  new String(stringBuffer);
    }

    public static String[][] show(String[][] arr,String s){
        int count = 0;
        int rowLen = arr[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < arr.length; j++) {
               if (arr[j][i] == "1" && (count < s.length())){
                   char c = s.charAt(count);
                   arr[j][i] = String.valueOf(c);
                   count++;
               }
            }
        }
        return arr;
    }
}
