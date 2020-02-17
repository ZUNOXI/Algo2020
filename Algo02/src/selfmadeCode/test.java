package selfmadeCode;

import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sen = "i am zuno";
		
		StringTokenizer st = new StringTokenizer(sen);
		
		System.out.println(st.nextToken());
		System.out.println(st.countTokens());
	}

}
