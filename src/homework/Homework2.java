package homework;

public class Homework2 {
	public static void main(String[] args) {
		//문자 reverse 하기
		//1.input "abcd"    => "dcba"
		//2.input "abcde"   => "edcba"
		
		String input = "abcd";//"abcde"
		char[] ch = input.toCharArray();
		
		for(int i=0;i<ch.length/2;i++){
			char temp = ch[i];
			ch[i] = ch[ch.length-1-i];
			ch[ch.length-1-i] = temp;
		}
		
		System.out.println(new String(ch));
		
		//2. 소수구하기
		
		for(int i=2;i<=100;i++){
			int count  = 0;
			for(int j=2;j<i;j++){
				if(i % j == 0){
					count++;
					break;
				}
			}
			if(count == 0){
				System.out.print(i + " ");
			}
		}
	}
}
