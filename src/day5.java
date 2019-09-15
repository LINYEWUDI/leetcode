/**
 *
 */

public class day5 {

    public static void main(String[] args) {
        String str = "ababa";
        String str1 = "cbbd";
        String max = max(str1);

        System.out.println(max);

    }

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