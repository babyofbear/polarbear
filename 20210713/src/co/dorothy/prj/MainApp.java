package co.dorothy.prj;

public class MainApp {
	
	public static void main(String[] args) {
		
//		HelloJava helloJava = new HelloJava("이프 연습인가요?");
//		
//		IfTest ifTest = new IfTest(); // 사용할 클래스를 초기화 한다.(인스턴스 한개 생성)//클래스명+클래스명소문자 ===>인스턴스 생성 or클래스 생성
//		ifTest.simpleIF();
//		helloJava.toString();
//		
//		ifTest.ifElseIf();
//		ifTest.ifElseTest();
		
//		ForTest forTest = new ForTest();
//		forTest.singleFor();
//		forTest.doubleFor();
//		forTest.forEach();
		
		MenuTest mainMenu = new MenuTest();
		mainMenu.run();		
		
	}
}

//모든 class는 main() 만들지 않는다.
//main() 는 MailApp Class에만 만든다.
//project 내에서 MainApp는 하나만 존재한다.
//Class안에 Class를 만들지 않는다


//		int a = 0;  변수 선언
//		IfTest ifTest = new IfTest();  class 선언 