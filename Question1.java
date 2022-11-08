package lab3;
import java.util.*;


public class Question1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.next();
		boolean result = isBalancedStringExp(str);
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.out.println("The entered Strings do  not contain Balanced Brackets");
		}
		sc.close();
	}
	
	static boolean isBalancedStringExp(String input) {
		Stack<Character> data = new Stack<Character>();
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				data.push(ch);
				continue;
			}
			// We are encountering close braces and stack is empty(no corresponding open braces)
			if(data.isEmpty()) {
				return false;
			}
			char matchCh = data.pop();
			switch(ch) {
				case ')':
					if(matchCh != '(') {
						return false;
					}
					break;
				case ']':
					if(matchCh != '[') {
						return false;
					}
					break;
				case '}':
					if(matchCh != '{') {
						return false;
					}
					break;
			}
		}
		return data.isEmpty();
	}
	

}
