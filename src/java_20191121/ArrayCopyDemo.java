package java_20191121;

public class ArrayCopyDemo {
	public static void main(String[] args){
		String[] fruits = {"apple", "banana","watermelon","peach"};
		
		String[] temp = new String[6];
		// fruits => 원본배열
		// 0 => 원본배열의 위치. 즉 원본배열의 복사할 시작위치
		// temp => 복사할 배열
		// 2 => 복사할 배열의 시작위치
		// 4 => 원본배열의 4개 요소를 복사
		System.arraycopy(fruits, 0, temp, 2, 4);
		temp[0] = "blueberry";
		temp[1] = "rasberry";
		
		for (String fruit : temp) {
			System.out.println(fruit);
		}
		
		String[] ref = fruits;
		ref[0] = "jobs";
		
		System.out.println(fruits[0]);
		System.out.println(ref[0]);
		
		
		int[] a = {1,2,3,4};
		int[] b = {1,2,3,4};
		int[] c = b;
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(a==c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}







