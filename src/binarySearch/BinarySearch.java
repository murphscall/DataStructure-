package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
	// 이진 탐색
	/*
		start 포인터는 배열의 맨 앞(인덱스 0), end 포인터는 배열의 맨 뒤를 가리킵니다.

		mid 포인터를 (start + end) / 2 위치에 둡니다.

		mid 위치의 값과 찾으려는 목표 값(target)을 비교합니다.

		arr[mid] == target 이면, 값을 찾았으므로 탐색을 종료합니다.

		arr[mid] < target 이면, 목표 값이 더 오른쪽에 있다는 뜻이므로, 탐색 범위를 오른쪽 절반으로 좁힙니다. (start = mid + 1)

		arr[mid] > target 이면, 목표 값이 더 왼쪽에 있다는 뜻이므로, 탐색 범위를 왼쪽 절반으로 좁힙니다. (end = mid - 1)

		start 포인터가 end 포인터보다 커지면 탐색 범위에 더 이상 원소가 없다는 뜻이므로 탐색을 종료합니다.

	*/


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		int M = Integer.parseInt(br.readLine());
		int[] X = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();


		for(int i =0; i<X.length; i++){
			int start = 0;
			int end = A.length -1;
			boolean found = false;


			while(start <= end){
				int mid = (start + end) / 2;

				if(A[mid] > X[i]){
					end  = mid-1;
				}else if(A[mid] < X[i]){
					start = mid+1;
				}else{
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}
	}
}
