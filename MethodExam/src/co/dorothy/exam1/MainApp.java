package co.dorothy.exam1;

public class MainApp {
	public static void main(String[] args) {
		MethodTest methodTest = new MethodTest();
		methodTest.strTest();//void type 호출
		
		String name = methodTest.strTest2(); //같은 타입의 그릇을 만들어줌
		System.out.println(name);
		
		String str = methodTest.strTest3();
		System.out.println(str);
	}

}
