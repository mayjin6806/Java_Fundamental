package java_20191125;

public class CalendarDemo {
	private int year;
	private int month;
	private int day;
	private int totalCount;
	private int[] monthArray = { 31, 30, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public CalendarDemo(int y){
		//year = y;
		this(y,0,0);
	}
	
	public CalendarDemo(int y, int m){
		//year = y;
		//month = m;
		this(y,m,0);
		
	}
	
	public CalendarDemo(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
		getTotalCount();
	}
	
	public void set(int y, int m, int d){
		year = y;
		month = m;
		day = d;
		getTotalCount();
	}
	private int getTotalCount(){
		// preYear => 2018년도
		int preYear = year - 1;
		// preMonth => 2019년 11월
		int preMonth = month - 1;
		//int totalCount = 0;

		// 2018년도까지 총일수를 구한다.
		totalCount = preYear * 365 + 
				(preYear / 4 - preYear / 100 + preYear / 400);
		//2019년도가 윤년인지 아닌지를 판단한다.
		boolean isLeafYear = 
				year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		
		//2019년도의 2월이 윤년인지를 판단하여 윤년이면 2월 29일로 만든다.
		if (isLeafYear) {
			monthArray[1] = 29;
		}

		// 2019년도 11월 까지 총 일수를 구한다.
		for (int i = 0; i < preMonth; i++) {
			totalCount += monthArray[i];
		}
		
		//2019년 11월까지 구한 총일수에 날짜를 더한다.
		totalCount += day;
		
		return totalCount;
	}
	public void print(){
		String message = null;
		int dayOfWeek = totalCount % 7;
		if (dayOfWeek == 1) {
			message = "월요일";
		} else if (dayOfWeek == 2) {
			message = "화요일";
		} else if (dayOfWeek == 3) {
			message = "수요일";
		} else if (dayOfWeek == 4) {
			message = "목요일";
		} else if (dayOfWeek == 5) {
			message = "금요일";
		} else if (dayOfWeek == 6) {
			message = "토요일";
		} else if (dayOfWeek == 0) {
			message = "일요일";
		}
		System.out.printf("%d년 %d월 %d일 %s 입니다.", 
				year, month, day, message);

	}
	/*
	public CalendarDemo(){
		
	}
	*/
	public static void main(String[] args) {
		CalendarDemo c = new CalendarDemo(2019,12,25);
		//c.set(2019,12,25);
		//c.getTotalCount();
		c.print();
	}
}








