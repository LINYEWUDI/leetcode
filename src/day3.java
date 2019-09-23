import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     */


    /**
     *  三层循环
     *  思想：站在易于理解的角度,
     *  1.编写方法,入参为字符串s,起点start,终点end,
     *      拿到该固定字符串的最长不重复子串
     *  2.两层for循环  外层控制第一个定死,内层往后扫一遍,遍历过程中  将每一次循环的字符串,起点,终点  都传入方法中获取本次字符串的最长不重复子串.
     *                  外层将第二个定死,内层往后扫,按上述操作进行.直到找到最长的为止
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                int max1 = getMax(s, i, j);
                max = Math.max(max,max1);
            }
        }

        return max;
    }
    public static int getMax(String s, int start, int end){
        HashSet<Object> set = new HashSet<>();

        for (int k = start; k < end; k++) {
            //拿到每一个字符
            char c = s.charAt(k);

            if (set.contains(c))    return set.size();

            set.add(c);

        }
        return end - start;
    }


    /**
     * 滑动窗口
     * 思想：首先初始化hashmap键值对,键：字符  值：在字符串中所在下标+1
     * 初始化 开始和结束变量,循环开始后固定start变量,然后end变量往后扫描,
     * 每扫描一个判断这个字符在不在hashmap中,若不存在则添加进集合中,
     * 若存在 则重置start(start和重复字符在hashmap中的值进行比较,取较大的一个赋值)
     * 每次循环过后判断  当前的保存的最长长度  与 end和start变量差值  的长度
     * 直至循环结束
     */
    public static int lengthOfLongestSubstring1(String s) {
        //字符串长度
        int len = s.length();
        //初始化最大字符串长度
        int max = 0;
        //初始化hashmap
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //初始化两个变量,起始和终止
        for (int start = 0, end = 0; end < len; end++) {
            if (hashMap.containsKey(s.charAt(end))){
                start = Math.max(start,hashMap.get(s.charAt(end)));
            }

            hashMap.put(s.charAt(end),end+1);
            max = Math.max(max,end-start+1);
        }

        return max;
    }


    /**
     * 官方解法2
     */

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        String s = "abcaefbb";
        String s1 = "pwwkew";
        String s2 = "cdd";
        String s3 = " ";
        String s4 = "aab";


        System.out.println(lengthOfLongestSubstring3(s));
    }
}
