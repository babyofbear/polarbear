package co.dorothy.prj;

public class HelloJava { //생성자 오버로딩(다형성 생성자)
	private String str; //멤버 변수
	
	public HelloJava() {
		// 기본생성자
	}
	
	public HelloJava(String str) {  //생성자 오버로딩(메소드 명이 똑같은데 전달 인자가 다르다.)
		this.str = str;
	}

//===============================위로 데이터 ========밑으로 메소드==========	
	
	public String getStr() {//기억된 값을 가져옴
		return str;
	}

	public void setStr(String str) { //값을 기억시킴
		this.str = str;
	}

	@Override
	public String toString() { //Object 객체로 상속받은 toString 메소드를 재정의함
		System.out.println(str);
		return null;
	}
	
	
} // 제일 먼저 작성
