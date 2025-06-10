import java.time.chrono.MinguoChronology;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class QuickSort {

	public static void quickSort(int[] arr , int left , int right){
		if(left > right ) return;

		LinkedList list = new LinkedList<>();
		int pivot = arr[left];
		int start = left + 1;
		int end = right;


		while(start < end){

			while(start <= end && arr[start] < pivot) start ++;

			while(start <= end && arr[end] > pivot ) end--;


			if(start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}

		}

		int temp = arr[left];
		arr[left] = arr[end];
		arr[end] = temp;

		quickSort(arr , left , end -1);
		quickSort(arr , end + 1, right);

	}

	public static void main(String[] args) {
		int[] arr = {5,3,4,7,8};


		int left = 0;  // 가장 왼쪽
		int right = arr.length -1; // 가장 오른쪽

		int pivot = arr[left]; // 기준 값
		int i = left + 1; // 기준값과 처음으로 비교 시작할 값
		int j = right; //  마지막 가장 오른쪽 값

		while ( i <=j ){
			// i 가 마지막 인덱스 보다 작고 arr[i] 의 값이 기준값 보다 작으면 i ++-+
			while(i <= right && arr[i] <= pivot) i++;

			while (j > left && arr[j] >= pivot) j--;


			if (i < j ){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if (left != j) {
			int temp = arr[left];
			arr[left] = arr[j];
			arr[j] = temp;
		}



	}

}
