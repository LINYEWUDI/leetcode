
public class day7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));


    }
    public static int reverse(int x) {

        if (x == 0){
            return 0;
        }
        int flag = 0;

        if (x < 0){
            x = -x;
            flag = 1;
        }
        String s = String.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer reverse = stringBuffer.reverse();

        String str = new String(reverse);
        if (reverse.charAt(0) == '0'){
            str = new String(reverse.substring(1,reverse.length()));
        }
        int i = 0;
        try {
            i = Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }

        if (flag == 1){
            i = -i;
        }
        return i;
    }
}
