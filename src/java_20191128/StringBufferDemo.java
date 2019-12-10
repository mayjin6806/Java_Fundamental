package java_20191128;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");
		//StringBufer 클래스는 Object의 equals() 메서드를 overriding 하지 
		//않았기 때문에 StringBuffer의 equals()를 사용하면 false가 반환된다.
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1);
		
		String s3 = s1.toString();
		String s4 = s2.toString();
		System.out.println(s3.equals(s4));
		
		StringBuffer sql = new StringBuffer();
		sql.append("select name, age ");
		sql.append("from member ");
		sql.append("where name = '성영한' ");
		sql.append("order by name desc ");
		
		System.out.println(sql);
		
		//sql의 모든 문자열 지우기
		sql.setLength(0);
		
		sql.append("select no, writer ");
		sql.append("from board");
		
		System.out.println(sql);
		
		
		
		
	}
}








