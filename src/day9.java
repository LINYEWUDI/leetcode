import org.junit.Test;

public class day9 {


  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
  }

  public static boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    StringBuffer stringBuffer = new StringBuffer(s) ;
    StringBuffer reverse = stringBuffer.reverse();

    if (s.equals(new String(reverse))){
      return true;
    }

    return false;
  }
}
