import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "cdd";
        String s3 = " ";
        String s4 = "aab";


        System.out.println(lengthOfLongestSubstring(s4));

    }
}
