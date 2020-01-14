public class day344 {

  public static void main(String[] args) {
    final char[] chars = {'h', 'e', 'l', 'l', 'o'};
    reverseString(chars);
  }

  public static void reverseString(char[] s) {

    int left = 0;
    int right = s.length;

    change(left,right-1,s);

    System.out.println(s);

  }


  public static void change(int left,int right,char[] s) {
    if (left>=right){
      return;
    }

    char temp = s[left];
    s[left] = s[right];
    s[right] = temp;

    change(++left,--right,s);
  }


}
