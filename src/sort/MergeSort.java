package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i =0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		merge_sort(arr , 0 , arr.length -1);

		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}


	}


	static void merge_sort(int[] arr , int start , int end){
		if(start < end){
			int mid = (start + end) / 2;
			//왼쪽
			merge_sort(arr,start,mid);
			merge_sort(arr,mid + 1 , end);

			merge(arr,start,mid,end);
		}
	}

	static void merge(int[] arr,int start ,int mid ,int end){
		int i = start , j =mid+1 , k=0;
		int[] temp = new int[end - start + 1];

		while(i <= mid && j <= end){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
			}
		}

		while(i <= mid){
			temp[k++] = arr[i++];
		}


		while(j <= end){
			temp[k++] = arr[j++];
		}

		for(int idx = 0; idx < k; idx++){
			arr[start + idx] = temp[idx];
		}

	}
}
