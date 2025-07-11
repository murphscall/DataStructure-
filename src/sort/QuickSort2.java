package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quick_Sort(arr , 0 , arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	static void quick_Sort(int[] arr, int start , int end){
		if (start >= end) {
			return;
		}

		// 1. 분할(Partition) 후 피벗의 최종 위치를 받음
		int pivotIndex = partition(arr, start, end);

		// 2. 피벗을 기준으로 나뉜 두 부분에 대해 재귀적으로 퀵 정렬 호출
		quick_Sort(arr, start, pivotIndex - 1); // 왼쪽 부분
		quick_Sort(arr, pivotIndex + 1, end);
	}
	static int partition(int[] arr , int start , int end){

		int pivot = arr[start];
		int i = start + 1;
		int j = end;

		while(i  <= j){

			while(i <= end && arr[i] <= pivot) i++;
			while(j > start && arr[j] >= pivot) j--;

			if(i > j){
				swap(arr , start , j);
			}else{
				swap(arr, i , j);
			}
		}

		return j;

	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
/*
* ## 퀵 정렬의 '분할' 과정 (Step-by-Step)
목표: 피벗 5를 기준으로, 5보다 작은 값은 왼쪽 그룹, 큰 값은 오른쪽 그룹으로 나눕니다.

배열: [5, 4, 3, 2, 1]

pivot = 5 (배열의 첫 번째 값)

start 포인터: pivot 바로 다음 위치에서 시작 (인덱스 1, 값 4)

end 포인터: 배열의 맨 끝 위치에서 시작 (인덱스 4, 값 1)

1단계: start와 end 포인터 이동
두 포인터는 각자의 임무를 가지고 서로를 향해 다가옵니다.

start의 임무: pivot(5)보다 큰 값을 찾을 때까지 오른쪽으로 이동 ➡️

end의 임무: pivot(5)보다 작은 값을 찾을 때까지 왼쪽으로 이동 ⬅️

   pivot    start                   end
    ↓        ↓                       ↓
   [5,       4,       3,       2,       1]
start 이동:

arr[start](4)는 5보다 크지 않습니다. start 이동.

arr[start](3)은 5보다 크지 않습니다. start 이동.

arr[start](2)는 5보다 크지 않습니다. start 이동.

arr[start](1)은 5보다 크지 않습니다. start 이동.

start는 end와 마주쳤으므로 일단 멈춥니다.

   pivot                           s,e
    ↓                            ↓ ↓
   [5,       4,       3,       2,       1]
end 이동:

arr[end](1)은 5보다 작습니다. 임무 완수! end는 그 자리에 멈춥니다.

2단계: 포인터 교차 후, 피벗 교환 (Swap)
start와 end 포인터가 각자 임무를 수행하다가 서로 교차하거나 만나면(start >= end), 탐색이 끝납니다.

이제 가장 중요한 마지막 작업을 합니다.

end 포인터가 멈춘 위치의 값과 **pivot의 값을 서로 교환(swap)**합니다.

   pivot                           end
    ↓                               ↓
   [5,       4,       3,       2,       1]

   // pivot(5)과 arr[end](1)을 교환
   [1,       4,       3,       2,       5]
3단계: 분할 완료
교환이 끝나면 피벗이었던 5는 자기 자리를 찾은 것입니다. 그리고 5의 왼쪽에는 모두 5보다 작은 값들만 남게 되었습니다.

분할 결과: {1, 4, 3, 2} | {5}

이제 남은 왼쪽 부분 배열 {1, 4, 3, 2}에 대해 방금 했던 1~3단계의 퀵 정렬을 똑같이 재귀적으로 반복하면 정렬이 완료되는 것입니다.
* */