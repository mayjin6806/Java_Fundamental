package java_20191126.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		s.startNano();
		for(long i=0;i<5000000000l;i++){
			
		}
		s.stopNano();
		double elapsedTime = s.getElapsedNanoTime();
		System.out.printf("경과시간 : %.9f", elapsedTime);
	}
}
