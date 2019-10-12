import java.util.LinkedList;
import java.util.List;

public class day17 {
	/**
	 *	思想：
	 *	1.初始化链表集合当队列
	 *	2.将第一个数字中的字母放入集合中
	 */
  public static List<String> letterCombinations(String digits) {
 		//初始化链表
		LinkedList<String> list = new LinkedList<>();
   	//对应九宫格的按键
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		list.add("");

		if (digits.isEmpty()) return list;

		for (int i = 0; i < digits.length(); i++) {
			//拿到输入的单个数字
			int location = Integer.parseInt(String.valueOf(digits.charAt(i)));

			while (list.peek().length() == i){
				String remove = list.remove();
				for (char c : mapping[location].toCharArray()) {
					list.add(remove+c);
				}
			}
		}

		return list;
	}


	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

}
