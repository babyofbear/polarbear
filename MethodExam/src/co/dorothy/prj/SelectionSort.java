package co.dorothy.prj;

public class SelectionSort {
	private int[] arr = { 5, 2, 4, 1, 3 };

	public void selectSort() { // 전통적 선택 소트
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) { // asc sort 오름차순 < desc sort 내림차순
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int n : arr) {
			System.out.print(n + " : ");
		}
	}

	public void selectSort2() { //진화된 선택 소트(시험에 나올 수 있음)
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		for (int n : arr) {
			System.out.print(n + " : ");
		}
	}
	//bubble sort 인접한 두 개를 비교
	
}
