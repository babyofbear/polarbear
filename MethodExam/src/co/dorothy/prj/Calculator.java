package co.dorothy.prj;

public class Calculator {
	public int sum(int a, int b) {
		return a+b;
	}
	
	public void sub(int a, int b) { //함수 오버로딩
		System.out.println(a-b);
	}
	
	public void sub(float f, int b) { //함수 오버로딩-전달인자나 리턴타입이 달라도 동일한 함수명으로 만듦
		System.out.println(f-b);
	}
	
	public long sub(long l, long m) {
		return l-m;
	}

}
