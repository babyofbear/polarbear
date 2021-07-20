package co.dorothy.exam1;

public class MethodTest {
	void strTest() {
		System.out.println("보이드 타입 테스트");
	}
	
	public String strTest2() { //String 타입으로 리턴
		return "홍길동";  //String 타입의 값을 리턴 구문에 대입
	}
	
	String strTest3() {
		String str = "박승리 기자";
		return str; //String 타입에 변수(객체)를 대입
	}

}
