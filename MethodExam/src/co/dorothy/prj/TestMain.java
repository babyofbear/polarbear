package co.dorothy.prj;

import java.util.Arrays;
import java.util.Collections;

import co.dorothy.exam1.IntMethod;
import co.dorothy.exam1.MethodTest;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IntMethod intMethod = new IntMethod();
//		intMethod.sum();
//		
//		MethodTest methodTest = new MethodTest(); //리턴 타입의 변수(그릇)를 만들어서 받아야한다.
//		methodTest.strTest2();
//		System.out.println(methodTest.strTest2());
//		
//		Calculator calculator = new Calculator();
//		int c = calculator.sum(10, 20);
//		System.out.println(c);
		
//		calculator.sub(10.0f, 20);
		Integer [] arr2 = { 5, 2, 4, 1, 3 };
		
		SelectionSort selectSort = new SelectionSort();
		selectSort.selectSort2();
		System.out.println("============");
		Arrays.sort(arr2); //SelectinSort class 의 현대적 방법. arrays. 메소드 이용.
		for(int n : arr2) {
			System.out.print(n + " : ");
		}
//		Arrays.sort(arr2,Collections.reverseOrder());
//		System.out.println("============");
//		for(int n : arr2) {
//			System.out.print(n + " : ");
//		}
	}

}
