package co.dorothy.prj;

public class ForTest {
	
	public void singleFor() {
		int sum = 0;
		for(int i = 0; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("100까지 합의 결과는 ="+ sum);
		
	}
	
	public void doubleFor() {
		for(int dan = 2; dan <=9; dan++) {
			System.out.println("========="+dan+"단=========");
			for(int i =1; i <=9; i++ ) {
				System.out.println(dan +"*" + i + "=" +dan*i);
			}
		}
	}
	
	public void forEach() { //for(Type 변수 : 객체) {   }--> for( i=
		int arr[] = {1,4,2,3,7,5,9};
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]+"==for문 출력");
		}
		
		for(int num : arr) {
			System.out.println(num);
		}
	}

}
